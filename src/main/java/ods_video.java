import bean.Video;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import utils.JsonUtils;
import utils.MyKafkaUtils;

import java.util.Properties;

public class ods_video {
    public static MyKafkaUtils myKafkaUtils = new MyKafkaUtils();
    public static Properties props;
    public static void main(String[] args) throws Exception {
        //获取环境
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        //配置kafka集群信息
        props = new Properties();
        props.setProperty("bootstrap.servers","hadoopmaster:9092");
        props.setProperty("group.id", "consumer-group");
        props.setProperty("key.deserializer",
                "org.apache.kafka.common.serialization.StringDeserializer");
        props.setProperty("value.deserializer",
                "org.apache.kafka.common.serialization.StringDeserializer");
        props.setProperty("auto.offset.reset", "latest");
        DataStreamSource<String> raw_videos_source = myKafkaUtils.getSource("test", props, env);

        //过滤掉删除操作
        SingleOutputStreamOperator<String> removeDeleteOpFilter = raw_videos_source.filter(data ->
                data.indexOf("\"type\":\"DELETE\"") == -1
        );
        /**
         * 将kafka读入的字符串数据源转换成video对象数据源
         * 此处应该分流，分成热门视频和普通视频
         * 分流后每个热门视频都有相关推荐
         */
        SingleOutputStreamOperator<Video> videoStreamSource = removeDeleteOpFilter.map(data ->
                JsonUtils.String2Video(data)
        );
        videoStreamSource.print();
        env.execute();

    }

}

package utils;

import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer;

import java.util.Properties;

public class MyKafkaUtils {
    /**
     * 传入指定消费的kafka topic，返回topic数据源
     * @param topic
     * @param props
     * @param env
     * @return
     */
    public DataStreamSource<String> getSource(String topic, Properties props, StreamExecutionEnvironment env){
        DataStreamSource<String> stringDataStreamSource = env.addSource(new FlinkKafkaConsumer<String>(topic, new SimpleStringSchema(), props));
        return stringDataStreamSource;
    }
}

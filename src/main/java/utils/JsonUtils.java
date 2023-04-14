package utils;

import bean.Video;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class JsonUtils {

    /**
     * 用于将生字符转换成Video对象的方法
     * @param str
     * @return
     */
    public static Video String2Video(String str){
        System.out.println(str);
        //字符串转换成json
        JSONObject sqljsonObject = JSON.parseObject(str);
        //获取data数组
        JSONArray data = sqljsonObject.getJSONArray("data");
        //获取视频信息，转成视频json
        JSONObject videoJson = data.getJSONObject(0);
        Video video = JSON.toJavaObject(videoJson, Video.class);
        return video;
    }
}

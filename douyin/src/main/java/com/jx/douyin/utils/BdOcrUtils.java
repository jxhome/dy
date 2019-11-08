package com.jx.douyin.utils;

import com.baidu.aip.ocr.AipOcr;
import org.json.JSONObject;

import java.util.HashMap;


/**
 * @Description TODO
 * @Author jx
 * @Date 2019/5/21 14:35
 */
public class BdOcrUtils {
    //设置APPID/AK/SK
    public static final String APP_ID = "16306554";
    public static final String API_KEY = "qnhtiUCVp4FGGFHyOX0j196z";
    public static final String SECRET_KEY = "LUsVDus7Qi2VUcdO399XThPgp66ch9zV";

    public static String getImgStr(String path) {
        // 初始化一个AipOcr
        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
       // client.setHttpProxy("proxy_host", null);  // 设置http代理
        //client.setSocketProxy("proxy_host", null);  // 设置socket代理

        // 可选：设置log4j日志输出格式，若不设置，则使用默认配置
        // 也可以直接通过jvm启动参数设置此环境变量
        System.setProperty("aip.log4j.conf", "src/main/resources/log4j.properties");

        // 调用接口
        //String path = "F:/open.jpg";
        JSONObject res = client.basicGeneral(path, new HashMap<String, String>());
        return res.toString();
    }

}

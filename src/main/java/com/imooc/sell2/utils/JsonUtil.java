package com.imooc.sell2.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author Shuhao Bai on 10/1/19
 * Json格式化工具，这样项目的各个地方都可以用到
 */
public class JsonUtil {
    // 将对象格式化成Json格式
    public static String toJson(Object object){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        return gson.toJson(object);
    }
}

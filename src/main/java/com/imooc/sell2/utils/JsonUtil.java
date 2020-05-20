package com.imooc.sell2.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author Shuhao Bai on 10/1/19
 * Json formating utils
 */
public class JsonUtil {
    public static String toJson(Object object){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        return gson.toJson(object);
    }
}

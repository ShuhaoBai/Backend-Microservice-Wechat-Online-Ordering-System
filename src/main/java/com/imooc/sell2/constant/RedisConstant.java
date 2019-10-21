package com.imooc.sell2.constant;

/**
 * redis常量
 * @author Shuhao Bai on 10/21/19
 */
public interface RedisConstant {
    String TOKEN_PREFIX = "token_%s";

    Integer EXPIRE = 7200; //2 hrs
}

package com.imooc.sell2.utils;

import java.util.Random;

/**
 * @author Shuhao Bai on 9/17/19
 */
public class KeyUtil {

    /**
     * 生成唯一的主键
     * 格式：时间+随机数
     * @return
     */
    public static synchronized String genUniqueKey(){ // 为了防止多线程并发，产生相同随机数，这里加synchronized关键字
        Random random = new Random();

        Integer number = random.nextInt(900000) + 100000; //生成6位随机数

        return System.currentTimeMillis() + String.valueOf(number);
    }
}

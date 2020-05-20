package com.imooc.sell2.utils;

import java.util.Random;

/**
 * @author Shuhao Bai on 9/17/19
 */
public class KeyUtil {

    public static synchronized String genUniqueKey(){
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000; //random number
        return System.currentTimeMillis() + String.valueOf(number);
    }
}

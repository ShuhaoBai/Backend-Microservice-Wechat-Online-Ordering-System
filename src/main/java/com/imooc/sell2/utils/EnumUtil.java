package com.imooc.sell2.utils;

import com.imooc.sell2.enums.CodeEnum;

/**
 * 枚举的一个工具类
 *
 * @author Shuhao Bai on 10/12/19
 */
public class EnumUtil {
    public static <T extends CodeEnum> T getByCode(Integer code, Class<T> enumClass) {
        for(T each: enumClass.getEnumConstants()){
            if(code.equals(each.getCode())){
                return each;
            }
        }
        return null;
    }
}

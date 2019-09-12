package com.imooc.sell2.enums;

import lombok.Getter;

/**
 * @author Shuhao Bai on 9/11/19
 */
@Getter
public enum ProductStatusEnum {
    UP(0, "在架"),
    DOWN(1, "下架");

    private Integer code;

    private String message;

    ProductStatusEnum(Integer code, String message){
        this.code = code;
        this.message = message;
    }
}

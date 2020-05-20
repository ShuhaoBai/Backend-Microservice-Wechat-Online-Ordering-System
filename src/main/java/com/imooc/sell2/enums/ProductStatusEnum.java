package com.imooc.sell2.enums;

import lombok.Getter;

/**
 * @author Shuhao Bai on 9/11/19
 */
@Getter
public enum ProductStatusEnum implements CodeEnum {
    UP(0, "on shelf"),
    DOWN(1, "off shelf");

    private Integer code;

    private String message;

    ProductStatusEnum(Integer code, String message){
        this.code = code;
        this.message = message;
    }
}

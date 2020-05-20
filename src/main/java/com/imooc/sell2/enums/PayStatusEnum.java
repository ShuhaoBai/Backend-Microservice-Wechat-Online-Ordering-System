package com.imooc.sell2.enums;

import lombok.Getter;

/**
 * @author Shuhao Bai on 9/12/19
 */

@Getter
public enum PayStatusEnum implements CodeEnum {
    WAIT(0, "Waiting for Payment"),
    SUCCESS(1, "Payment Success"),
    ;

    private Integer code;

    private String message;

    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}

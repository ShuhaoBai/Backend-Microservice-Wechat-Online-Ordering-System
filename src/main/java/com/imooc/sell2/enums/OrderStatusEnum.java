package com.imooc.sell2.enums;

import lombok.Getter;

/**
 * @author Shuhao Bai on 9/12/19
 */

@Getter
public enum OrderStatusEnum implements CodeEnum{
    NEW(0, "New Order"),
    FINISHED(1, "Completed"),
    CANCEL(2, "Canceled"),
    ;

    private Integer code;

    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}

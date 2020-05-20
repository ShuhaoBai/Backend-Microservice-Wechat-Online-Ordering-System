package com.imooc.sell2.enums;

import lombok.Getter;

/**
 * 返回给前端提示的一个消息
 *
 * @author Shuhao Bai on 9/12/19
 */
@Getter
public enum ResultEnum {

    SUCCESS(0, "Success"),
    PARAM_ERROR(1, "Parameter Error"),
    PRODUCT_NOT_EXIST(10, "Product not exist"),
    PRODUCT_STOCK_ERROR(11, "Product inventory error"),
    ORDER_NOT_EXIST(12, "Order non-existing"),
    ORDERDETAIL_NOT_EXIST(13, "Order detail not-existing"),
    ORDER_STATUS_ERROR(14, "Order status error"),
    ORDER_UPDATE_FAIL(15, "Order update error"),
    ORDER_DETAIL_EMPTY(16, "Order detail null"),
    ORDER_PAY_STATUS_ERROR(17, "Order payment status error"),
    CART_EMPTY(18, "Shopping cart empty"),
    ORDER_OWNER_ERROR(19,"Order not belonging to this user"),
    WECHAT_MP_ERROR(20, "Wechat MP error"),
    WXPAY_NOTIFY_MONEY_VERIFY_ERROR(21, "Wechat payment asyc auth fail"),
    ORDER_CANCEL_SUCCESS(22, "Order Canceled Successfully"),
    ORDER_FINISH_SUCCESS(23, "Order Completeed Successfully"),
    PRODUCT_STATUS_ERROR(24, "Order Status error"),
    LOGIN_FAIL(25,"Login Failed"),
    LOGOUT_SUCCESS(26, "Logout Successfully"),
    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}

package com.imooc.sell2.dto;

import lombok.Data;

/**
 * 购物车
 *
 * @author Shuhao Bai on 9/18/19
 */
@Data
public class CartDTO {

    /**商品id */
    private String productId;

    /**商品数量*/
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}

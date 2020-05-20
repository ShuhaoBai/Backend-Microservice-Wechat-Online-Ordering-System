package com.imooc.sell2.dto;

import lombok.Data;

/**
 * Cart DTO
 * @author Shuhao Bai on 9/18/19
 */
@Data
public class CartDTO {
    private String productId;
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}

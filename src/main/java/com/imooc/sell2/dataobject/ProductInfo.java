package com.imooc.sell2.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * 商品
 *
 * @author Shuhao Bai on 9/10/19
 */
@Entity
@Data
public class ProductInfo {

    @Id
    private String productId;

    /**名字。*/
    private String productName;

    /** price */
    private BigDecimal productPrice;

    /** inventory*/
    private Integer productStock;

    /** description*/
    private String productDescription;

    /**小图*/
    private String productIcon;

    /**状态, 0正常 1下架*/
    private Integer productStatus;

    /** 类目编号*/
    private Integer categoryType;



}

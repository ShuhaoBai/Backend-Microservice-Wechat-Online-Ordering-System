package com.imooc.sell2.form;

import lombok.Data;

import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @author Shuhao Bai on 10/13/19
 */

@Data
public class ProductForm {

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

//    /**状态, 0正常 1下架*/
//    private Integer productStatus;

    /** 类目编号*/
    private Integer categoryType;
}

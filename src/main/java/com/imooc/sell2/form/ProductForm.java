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
    private String productName;
    private BigDecimal productPrice;
    private Integer productStock;
    private String productDescription;
    private String productIcon;
    private Integer categoryType;
}

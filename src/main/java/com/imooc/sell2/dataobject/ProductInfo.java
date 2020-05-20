package com.imooc.sell2.dataobject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.imooc.sell2.enums.ProductStatusEnum;
import com.imooc.sell2.utils.EnumUtil;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Product Info
 *
 * @author Shuhao Bai on 9/10/19
 */
@Entity
@Data
@DynamicUpdate
public class ProductInfo {

    @Id
    private String productId;
    private String productName;
    private BigDecimal productPrice;
    private Integer productStock;
    private String productDescription;
    private String productIcon;
    private Integer categoryType;
    private Integer productStatus = ProductStatusEnum.UP.getCode();
    private Date createTime;
    private Date updateTime;

    @JsonIgnore
    public ProductStatusEnum getProductStatusEnum() {
        return EnumUtil.getByCode(productStatus, ProductStatusEnum.class);
    }


}

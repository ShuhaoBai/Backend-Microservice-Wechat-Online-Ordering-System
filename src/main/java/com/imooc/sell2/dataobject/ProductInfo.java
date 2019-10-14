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
 * 商品
 *
 * @author Shuhao Bai on 9/10/19
 */
@Entity
@Data
@DynamicUpdate
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

    /** 类目编号*/
    private Integer categoryType;

    /** 状态, 0正常1下架. */
    private Integer productStatus = ProductStatusEnum.UP.getCode();

    private Date createTime;

    private Date updateTime;

    @JsonIgnore
    public ProductStatusEnum getProductStatusEnum() {
        return EnumUtil.getByCode(productStatus, ProductStatusEnum.class);
    }


}

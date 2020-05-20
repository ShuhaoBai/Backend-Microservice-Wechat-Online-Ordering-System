package com.imooc.sell2.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * Product & Category
 * @author Shuhao Bai on 9/11/19
 */
@Data
public class ProductVO {

    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer CategoryType;

    @JsonProperty("foods")
    private List<ProductInfoVO>  productInfoVOList;


}

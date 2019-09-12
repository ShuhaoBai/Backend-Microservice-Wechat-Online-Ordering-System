package com.imooc.sell2.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * 商品（包含类目）
 * @author Shuhao Bai on 9/11/19
 */
@Data
public class ProductVO {

    @JsonProperty("name") //这样返回给前端就会显示name这个名字
    private String categoryName;


    @JsonProperty("type")
    private Integer CategoryType;

    @JsonProperty("foods")
    private List<ProductInfoVO>  productInfoVOList;


}

package com.imooc.sell2.form;

import lombok.Data;

/**
 * @author Shuhao Bai on 10/14/19
 */

@Data
public class CategoryForm {

    private Integer categoryId;

    /**类目名字.*/
    private String categoryName;

    /**类目编号.*/
    private Integer categoryType;
}

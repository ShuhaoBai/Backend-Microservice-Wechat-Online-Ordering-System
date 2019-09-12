package com.imooc.sell2.service;

import com.imooc.sell2.dataobject.ProductCategory;

import java.util.List;

/**
 * @author Shuhao Bai on 9/11/19
 */
public interface CategoryService {

    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);
}
package com.imooc.sell2.dataobject.dao;

import com.imooc.sell2.dataobject.ProductCategory;
import com.imooc.sell2.dataobject.mapper.ProductCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * @author Shuhao Bai on 1/11/20
 */
public class ProductCategoryDao {
    @Autowired
    ProductCategoryMapper mapper;

    public int insertByMap(Map<String, Object> map){
        return mapper.insertByMap(map);
    }
}

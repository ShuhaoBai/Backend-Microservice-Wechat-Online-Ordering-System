package com.imooc.sell2.dataobject.mapper;

import com.imooc.sell2.dataobject.ProductCategory;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * @author Shuhao Bai on 1/11/20
 * 对product category的增删改查
 */
public interface ProductCategoryMapper {

    // write in,  insert
    @Insert("insert into product_category(category_name, category_type) values(#{category_name, jdbcType=VARCHAR}, #{category_type, jdbcType=INTEGER)")
    int insertByMap(Map<String, Object> map);

    @Insert("insert into product_category(category_name, category_type) values(#{category_name, jdbcType=VARCHAR}, #{categoryType, jdbcType=INTEGER)")
    int insertByObject(ProductCategory productCategory);

    //search
    @Select("select * from product_category where category_type = #{categoryType}")
    @Results({
            @Result(column = "category_id", property = "categoryId"),
            @Result(column = "category_name", property = "categoryName"),
            @Result(column = "category_type", property = "categoryType")
    })
    ProductCategory findByCategoryType(Integer categoryType);

    @Select("select * from product_category where category_name = #{categoryName}")
    @Results({
            @Result(column = "category_id", property = "categoryId"),
            @Result(column = "category_name", property = "categoryName"),
            @Result(column = "category_type", property = "categoryType")
    })
    List<ProductCategory> findByCategoryName(String categoryName);

    @Update("update product_category set category_name = #{categoryName} where category_type = #{categoryType}")
    int updateByCategoryType(@Param("categoryName") String categoryName,
                             @Param("categoryType") Integer categoryType);

    @Update("update product_category set category_name = #{categoryName} where category_name = #{categoryName")
    int updateByObject(ProductCategory productCategory);

    @Delete("delete from product_category where category_name = #{categoryName")
    int deleteByCategoryType(Integer categoryType);

    //put SQL syntax into XML file to implement SQL operations
    ProductCategory selectByCategoryType(Integer categoryType);


}

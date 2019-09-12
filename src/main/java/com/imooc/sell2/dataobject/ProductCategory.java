package com.imooc.sell2.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * 类目
 *
 * @author Shuhao Bai on 9/7/19
 * =======================
 * 如果数据库里table的名字跟这个code里的public class名字不一样，那么可以这样：
 * @Table(name = "数据库里的名字"）
 * public class xxx {
 *
 * }
 * =======================
 */
@Entity //将数据库映射成对象
@DynamicUpdate //数据库更新时动态更新 更新时间
@Data //这是lombok插件，有了这个@Data，就不用每次新建getter()和setter()方法了，连toString()方法都不用写了，包含了
public class ProductCategory {
    /**类目id.*/
    @Id // 这个是把DB中的primary key在Java中命名成Id，这样后面就可以用Id来调用DB中的primary key了。
    @GeneratedValue(strategy = GenerationType.IDENTITY)//这个是用来在数据库中auto-increment Id的，where Id is the primary key in the DB。
    // Auto-increment：当我们往数据库中加入新的row的时候，每一条数据的primary key（也就是Id），要自动+1，这样才能给每条数据编号（也就primary key - Id）
    private Integer categoryId;

    /**类目名字.*/
    private String categoryName;

    /**类目编号.*/
    private Integer categoryType;

    public ProductCategory() {
    }

    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }
}


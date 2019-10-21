package com.imooc.sell2.repository;

import com.imooc.sell2.dataobject.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * SellerInfo的DAO
 *
 * @author Shuhao Bai on 10/21/19
 */
public interface SellerInfoRepository extends JpaRepository<SellerInfo, String> {
    //通过openid来查询他的信息
    SellerInfo findByOpenid(String openid);
}

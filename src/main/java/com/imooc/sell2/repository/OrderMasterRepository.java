package com.imooc.sell2.repository;

import com.imooc.sell2.dataobject.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Shuhao Bai on 9/12/19
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {
    Page<OrderMaster> findByBuyerOpenid(String buyerOpenid, Pageable pageable);
}

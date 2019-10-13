package com.imooc.sell2.service;

import com.imooc.sell2.dataobject.OrderMaster;
import com.imooc.sell2.dto.OrderDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author Shuhao Bai on 9/12/19
 */
public interface OrderService {
    /**创建订单*/
    OrderDTO create(OrderDTO orderDTO);

    /**查询单个订单*/
    OrderDTO findOne(String orderId);

    /**查询（单人）订单列表*/
    Page<OrderDTO> findList(String buyerOpenid, Pageable pageable);

    /**取消订单*/
    OrderDTO cancel(OrderDTO orderDTO);

    /**完结订单*/
    OrderDTO finish(OrderDTO orderDTO);

    /**支付订单*/
    OrderDTO paid(OrderDTO orderDTO);

    /**查询所有人订单列表*/
    Page<OrderDTO> findList(Pageable pageable);
}

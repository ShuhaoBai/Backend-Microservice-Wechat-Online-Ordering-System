package com.imooc.sell2.service;

import com.imooc.sell2.dto.OrderDTO;

/**
 * 把取消一个订单，和查询一个订单的逻辑放进这个里面来做
 * 也可以在BuyerOrderController里做，但是比较繁琐
 * @author Shuhao Bai on 9/19/19
 */
public interface BuyerService {

    //查询一个订单
    OrderDTO findOrderOne(String openid, String orderId);

    //取消订单
    OrderDTO cancelOrder(String openid, String orderId);
}

package com.imooc.sell2.service;

import com.imooc.sell2.dto.OrderDTO;

/**
 * @author Shuhao Bai on 9/19/19
 */
public interface BuyerService {

    OrderDTO findOrderOne(String openid, String orderId);
    OrderDTO cancelOrder(String openid, String orderId);
}

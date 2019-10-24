package com.imooc.sell2.service;

import com.imooc.sell2.dto.OrderDTO;

/**
 * 推送消息
 *
 * @author Shuhao Bai on 10/24/19
 */
public interface PushMessageService {

    /**
     * 订单状态变更消息
     * @param orderDTO
     */
    void orderStatus(OrderDTO orderDTO);
}

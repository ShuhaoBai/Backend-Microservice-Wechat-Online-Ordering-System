package com.imooc.sell2.service;

import com.imooc.sell2.dto.OrderDTO;

/**
 *
 * @author Shuhao Bai on 10/24/19
 */
public interface PushMessageService {

    /**
     * @param orderDTO
     */
    void orderStatus(OrderDTO orderDTO);
}

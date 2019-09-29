package com.imooc.sell2.service;

import com.imooc.sell2.dto.OrderDTO;

/**
 * 支付
 * （这种接口Interface创建完了之后要写impl来实现它）
 * @author Shuhao Bai on 9/28/19
 */
public interface PayService {
    void create(OrderDTO orderDTO);
}

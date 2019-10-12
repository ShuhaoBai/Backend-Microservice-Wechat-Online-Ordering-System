package com.imooc.sell2.service;

import com.imooc.sell2.dto.OrderDTO;
import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.model.RefundResponse;

/**
 * 支付
 * （这种接口Interface创建完了之后要写impl来实现它：service/impl/PayServiceImpl）
 * @author Shuhao Bai on 9/28/19
 */
public interface PayService {
    PayResponse create(OrderDTO orderDTO);
    PayResponse notify(String notifyData);
    RefundResponse refund(OrderDTO orderDTO);
}

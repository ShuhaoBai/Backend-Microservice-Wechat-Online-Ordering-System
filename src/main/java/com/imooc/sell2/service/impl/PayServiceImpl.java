package com.imooc.sell2.service.impl;

import com.imooc.sell2.dto.OrderDTO;
import com.imooc.sell2.service.PayService;
import com.lly835.bestpay.model.PayRequest;
import com.lly835.bestpay.service.impl.BestPayServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 实现PayService interface接口
 * @author Shuhao Bai on 9/28/19
 */
@Service
public class PayServiceImpl implements PayService {
    @Autowired
    private BestPayServiceImpl bestPayService;

    @Override
    public void create(OrderDTO orderDTO) {

        PayRequest payRequest = new PayRequest();
        bestPayService.pay(payRequest);

    }
}

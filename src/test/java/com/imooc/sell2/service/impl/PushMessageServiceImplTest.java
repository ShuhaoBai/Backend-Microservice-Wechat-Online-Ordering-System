package com.imooc.sell2.service.impl;

import com.imooc.sell2.dto.OrderDTO;
import com.imooc.sell2.service.OrderService;
import com.imooc.sell2.service.PushMessageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Shuhao Bai on 10/24/19
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PushMessageServiceImplTest {

    @Autowired
    private PushMessageServiceImpl pushMessageService;

    @Autowired
    private OrderService orderService;
    @Test
    public void orderStatus() {
        OrderDTO orderDTO = orderService.findOne("12345677750");
        pushMessageService.orderStatus(orderDTO);
    }
}
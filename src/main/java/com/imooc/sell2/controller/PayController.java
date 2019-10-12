package com.imooc.sell2.controller;

import com.imooc.sell2.dto.OrderDTO;
import com.imooc.sell2.enums.ResultEnum;
import com.imooc.sell2.exception.SellException;
import com.imooc.sell2.service.OrderService;
import com.imooc.sell2.service.PayService;
import com.lly835.bestpay.model.PayResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * 支付controller
 *
 * @author Shuhao Bai on 9/28/19
 */
@Controller // 不是返回Json，而是返回一个界面，所以用@Controller就行
@RequestMapping("/pay")
public class PayController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private PayService payService;

    @GetMapping("/create")
    //ModelAndView是freemarker的应用
    public ModelAndView create(@RequestParam("orderId") String orderId,
                               @RequestParam("returnUrl") String returnUrl,
                               Map<String, Object> map) {
        //1.查询订单
        OrderDTO orderDTO = orderService.findOne(orderId);
        if(orderDTO == null){
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }

        //发起支付(我们把支付的逻辑都写到service层里去：service/PayService，是一个interface）
        PayResponse payResponse = payService.create(orderDTO);
        map.put("payResponse", payResponse);
        map.put("returnUrl", returnUrl);
        return new ModelAndView("pay/create", map);
    }

    //接收微信异步通知：
    //接受支付成功的通知
    @PostMapping("/notify")
    public ModelAndView notify(@RequestBody String notifyData) {
        // 根据微信支付开发文档，第10步： 异步通知商户支付结果()
        payService.notify(notifyData);
        // 根据微信支付开发文档，第11步：告知微信通知处理结果().
        // 返回给微信处理结果
        return new ModelAndView("pay/success");

    }
}

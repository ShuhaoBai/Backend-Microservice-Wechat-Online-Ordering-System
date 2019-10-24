package com.imooc.sell2.service.impl;

import com.imooc.sell2.config.WechatAccountConfig;
import com.imooc.sell2.dto.OrderDTO;
import com.imooc.sell2.service.PushMessageService;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @author Shuhao Bai on 10/24/19
 */
@Service
@Slf4j
public class PushMessageServiceImpl implements PushMessageService {
    @Autowired
    private WxMpService wxMpService;

    @Autowired
    private WechatAccountConfig accountConfig;

    @Override
    public void orderStatus(OrderDTO orderDTO){
        WxMpTemplateMessage templateMessage = new WxMpTemplateMessage();
        templateMessage.setTemplateId(accountConfig.getTemplateId().get("orderStatus"));
        templateMessage.setToUser(orderDTO.getBuyerOpenid());

        List<WxMpTemplateData> data = Arrays.asList(
                new WxMpTemplateData("first", "请记得收货"),
                new WxMpTemplateData("keyword1", "微信点餐"),
                new WxMpTemplateData("keyword2", "18888888888"),
                new WxMpTemplateData("keyword3", orderDTO.getOrderId()),
                new WxMpTemplateData("keyword4", orderDTO.getorderStatusEnum().getMessage()),
                new WxMpTemplateData("keyword5", "$"+orderDTO.getOrderAmount()),
                new WxMpTemplateData("remark", "Weclome come back!")

        );
        templateMessage.setData(data);
        try{
            wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage);
        } catch (WxErrorException e){ //这里catch掉错误就行，如果throw的话，会中断运行，如果客户下单，然后你推送一个消息给客户，但是推送消息这里出error了，结果你throw一个error出来，造成这一单下不了，影响赚钱
            //这个推送消息的异常没有那么重要，catch之后记录一个log就行了，没必要抛异常中断程序运行
            //No need to throw an error on pushing message, since it would interrupt the entire program
            //If a customer placed an order, and there is an error occurred when you try to push the order confirmation message to the customer
            //throwing an error would stop the entire program, thus, cancel customer's order
            //Error in pushing message is not critical, we just need to catch and log it, that's all.
            log.error("【微信模板消息】发送失败", e);
        }

    }
}

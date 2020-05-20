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
                new WxMpTemplateData("first", "Please receive the order."),
                new WxMpTemplateData("keyword1", "Wechat food order"),
                new WxMpTemplateData("keyword2", "18888888888"),
                new WxMpTemplateData("keyword3", orderDTO.getOrderId()),
                new WxMpTemplateData("keyword4", orderDTO.getorderStatusEnum().getMessage()),
                new WxMpTemplateData("keyword5", "$"+orderDTO.getOrderAmount()),
                new WxMpTemplateData("remark", "Weclome come back!")

        );
        templateMessage.setData(data);
        try{
            wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage);
        } catch (WxErrorException e){
            log.error("【Wechat Tamplate Message】Message Send Failed", e);
        }

    }
}

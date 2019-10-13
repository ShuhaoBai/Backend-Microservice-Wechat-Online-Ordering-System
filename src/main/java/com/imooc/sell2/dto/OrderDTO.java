package com.imooc.sell2.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.imooc.sell2.dataobject.OrderDetail;
import com.imooc.sell2.enums.OrderStatusEnum;
import com.imooc.sell2.enums.PayStatusEnum;
import com.imooc.sell2.utils.EnumUtil;
import com.imooc.sell2.utils.serializer.Date2LongSerializer;
import lombok.Data;

import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Shuhao Bai on 9/12/19
 */

@Data
//@JsonSerialize(include = JsonSerialize.Inclusion.NOT_NULL)
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDTO {

    /** 订单id */
    private String orderId;

    /** 买家名字*/
    private String buyerName;

    /** 买家电话*/
    private String buyerPhone;

    /** 买家地址*/
    private String buyerAddress;

    /** 买家微信Openid */
    private String buyerOpenid;

    /** 订单金额 */
    private BigDecimal orderAmount;

    /** 订单状态，默认为新下单 */
    private Integer orderStatus;

    /** 支付状态，默认为0未支付*/
    private Integer payStatus;

    /** 创建时间*/
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;

    /** 更新时间*/
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;

    List<OrderDetail> orderDetailList;

    @JsonIgnore
    //JsonIgnore will ignore following code when return Json
    public OrderStatusEnum getorderStatusEnum(){
        return EnumUtil.getByCode(orderStatus, OrderStatusEnum.class);
    }
    @JsonIgnore
    //JsonIgnore will ignore following code when return Json
    public PayStatusEnum getPayStatusEnum(){
        return EnumUtil.getByCode(payStatus, PayStatusEnum.class);
    }
}

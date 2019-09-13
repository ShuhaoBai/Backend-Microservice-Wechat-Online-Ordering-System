package com.imooc.sell2.dto;

import com.imooc.sell2.dataobject.OrderDetail;
import com.imooc.sell2.enums.OrderStatusEnum;
import com.imooc.sell2.enums.PayStatusEnum;
import lombok.Data;

import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author Shuhao Bai on 9/12/19
 */

@Data
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
    private Date createTime;

    /** 更新时间*/
    private Date updateTime;

    List<OrderDetail> orderDetailList;
}

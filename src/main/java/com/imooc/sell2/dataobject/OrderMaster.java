package com.imooc.sell2.dataobject;

import com.imooc.sell2.enums.OrderStatusEnum;
import com.imooc.sell2.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import java.math.BigDecimal;
import java.util.Date;

/**
 *订单
 * @author Shuhao Bai on 9/12/19
 */

@Entity
@Data
@DynamicUpdate
public class OrderMaster {
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
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();

    /** 支付状态，默认为0未支付*/
    private Integer payStatus = PayStatusEnum.WAIT.getCode();

    /** 创建时间*/
    private Date createTime;

    /** 更新时间*/
    private Data updateTime;
}

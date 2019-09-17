package com.imooc.sell2.service.impl;

import com.imooc.sell2.dataobject.OrderDetail;
import com.imooc.sell2.dataobject.OrderMaster;
import com.imooc.sell2.dataobject.ProductInfo;
import com.imooc.sell2.dto.OrderDTO;
import com.imooc.sell2.enums.ResultEnum;
import com.imooc.sell2.exception.SellException;
import com.imooc.sell2.repository.OrderDetailRepository;
import com.imooc.sell2.repository.OrderMasterRepository;
import com.imooc.sell2.service.OrderService;
import com.imooc.sell2.service.ProductService;
import com.imooc.sell2.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author Shuhao Bai on 9/12/19
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderMasterRepository orderMasterRepository; // 写入数据库用的

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Override
    public OrderDTO create(OrderDTO orderDTO) {

        String orderId = KeyUtil.genUniqueKey(); //整个order的id，在order生成的时候就应该生成
        BigDecimal orderAmount = new BigDecimal(BigInteger.ZERO);

        //1. 查询商品（数量，价格）
        for(OrderDetail orderDetail :orderDTO.getOrderDetailList()) {
            ProductInfo productInfo = productService.findOne(orderDetail.getProductId());
            if(productInfo == null){
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            //2. 计算订单总价
            orderAmount = orderDetail.getProductPrice()
                    .multiply(new BigDecimal(orderDetail.getProductQuantity()))
                    .add(orderAmount);

            //订单详情入库
            orderDetail.setDetailId(KeyUtil.genUniqueKey());
            orderDetail.setOrderId(orderId);
            BeanUtils.copyProperties(productInfo, orderDetail); // springboot自带的一个copy properties的方法，这样就可以把productInfo里的属性复制给orderDetail了（包括product的图片啊什么的）
            orderDetailRepository.save(orderDetail);

        }



        //3. 写入订单数据库（orderMaster，orderDetail）
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId(orderId);
        orderMaster.setOrderAmount(orderAmount);
        BeanUtils.copyProperties(orderDTO, orderMaster);
        orderMasterRepository.save(orderMaster); //存入数据库


        //4. 如果下单成功，扣库存
        return null;
    }

    @Override
    public OrderDTO findOne(String orderId) {
        return null;
    }

    @Override
    public Page<OrderDTO> findList(String buyerOpenid, Pageable pageable) {
        return null;
    }

    @Override
    public OrderDTO cancel(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO finish(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO paid(OrderDTO orderDTO) {
        return null;
    }
}

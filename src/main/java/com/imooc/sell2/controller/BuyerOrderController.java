package com.imooc.sell2.controller;

import com.imooc.sell2.VO.ResultVO;
import com.imooc.sell2.converter.OrderForm2OrderDTOConverter;
import com.imooc.sell2.dto.OrderDTO;
import com.imooc.sell2.enums.ResultEnum;
import com.imooc.sell2.exception.SellException;
import com.imooc.sell2.form.OrderForm;
import com.imooc.sell2.service.BuyerService;
import com.imooc.sell2.service.OrderService;
import com.imooc.sell2.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.xml.transform.Result;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Shuhao Bai on 9/19/19
 */
@RestController
@RequestMapping("/buyer/order")
@Slf4j
public class BuyerOrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private BuyerService buyerService;
    //创建订单
    @PostMapping("/create")
    public ResultVO<Map<String, String>> create(@Valid OrderForm orderForm,
                                                BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            log.error("【创建订单】参数不正确，orderForm={}", orderForm);
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }
        //参数正常的话，就继续往下走了
        OrderDTO orderDTO = OrderForm2OrderDTOConverter.convert(orderForm);
        //判断一下购物车是否为空
        if(CollectionUtils.isEmpty(orderDTO.getOrderDetailList())){
            log.error("【创建订单】购物车不能为空");
            throw new SellException(ResultEnum.CART_EMPTY);
        }

        OrderDTO createResult = orderService.create(orderDTO);

        Map<String, String> map = new HashMap<>();
        map.put("orderId", createResult.getOrderId());

        return ResultVOUtil.success(map);
    }

    //订单列表
    @GetMapping("/list")
    public ResultVO<List<OrderDTO>> list(@RequestParam("openid") String openid,
                                         @RequestParam(value = "page", defaultValue = "0") Integer page,
                                         @RequestParam(value = "size", defaultValue = "10") Integer size){
        if(StringUtils.isEmpty(openid)){
            log.error("【查询订单列表】openid为空");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        PageRequest request = new PageRequest(page, size);
        Page<OrderDTO> orderDTOPage = orderService.findList(openid, request);

        //转存Date -> Long
        return ResultVOUtil.success(orderDTOPage.getContent());
//        ResultVO resultVO = new ResultVO();
//        resultVO.setCode(0);
//        return resultVO;
    }

    //订单详情
    @GetMapping("/detail")
    public ResultVO<OrderDTO> detail (@RequestParam("openid") String openid,
                                     @RequestParam("orderId") String orderId){
        OrderDTO orderDTO = buyerService.findOrderOne(openid, orderId);

        return ResultVOUtil.success(orderDTO);
    }


    //取消订单
    @PostMapping("/cancel")
    public ResultVO cancel(@RequestParam("openid") String openid,
                           @RequestParam("orderId") String orderId){
        //TODO 不安全的做法，任何人一个传进来一个openid就都可查了，要改进
        buyerService.cancelOrder(openid, orderId);
        return ResultVOUtil.success();
    }

}

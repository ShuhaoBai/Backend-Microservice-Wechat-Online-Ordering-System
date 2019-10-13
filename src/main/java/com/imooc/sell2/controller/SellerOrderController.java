package com.imooc.sell2.controller;

import com.imooc.sell2.dto.OrderDTO;
import com.imooc.sell2.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * 卖家端订单
 *
 * @author Shuhao Bai on 10/12/19
 */

@Controller
@RequestMapping("seller/order")
public class SellerOrderController {

    @Autowired
    private OrderService orderService;

    /**
     *
     * @param page 第几页，从1页开始
     * @param size 一页有多少条数据
     * @return
     */
    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "size", defaultValue = "10") Integer size, Map<String, Object> map) {
        PageRequest request = new PageRequest(page - 1, size);
        Page<OrderDTO> orderDTOPage = orderService.findList(request);
        map.put("orderDTOPage", orderDTOPage);
        map.put("currentPage", page);
        map.put("size", size);
        //orderDTOPage.getTotalPages();
        return new ModelAndView("order/list", map);
    }

    /**
     * 取消订单
     * @param orderId
     * @return
     */
    @GetMapping
    public ModelAndView cancel(@RequestParam("orderId") String orderId){

    }
}

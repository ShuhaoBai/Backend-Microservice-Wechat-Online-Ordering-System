package com.imooc.sell2.repository;

import com.imooc.sell2.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Shuhao Bai on 9/12/19
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {
    @Autowired
    private OrderDetailRepository repository;

    @Test
    public void saveTest() {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("12345678910");
        orderDetail.setOrderId("1111dfs11");
        orderDetail.setProductId("111112");
        orderDetail.setProductName("皮蛋粥");
        orderDetail.setProductPrice(new BigDecimal(5));
        orderDetail.setProductQuantity(2);
        orderDetail.setProductIcon("http://yyy.jpg");

        OrderDetail result = repository.save(orderDetail);
        Assert.assertNotNull(result);//这里只要返回的result不等于Null就算通过

    }

    @Test
    public void findByOrderId() throws Exception{
        List<OrderDetail> orderDetailList = repository.findByOrderId("1111dfs11");
        Assert.assertNotEquals(0, orderDetailList.size()); //这里只要orderDetailList.size() 返回值不等于0，就算通过
    }
}

package com.imooc.sell2.enums;

/**
 * 让OrderStatusEnum和PayStatusEnum能够通过这个借口在其他类里面调用，就不用每个类都写PayStatusEnum和OrderStatusEnum了
 *
 * @author Shuhao Bai on 10/12/19
 */
public interface CodeEnum{
    Integer getCode();
}

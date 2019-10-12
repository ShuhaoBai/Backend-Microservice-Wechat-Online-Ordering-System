package com.imooc.sell2.utils;

/**
 * @author Shuhao Bai on 10/12/19
 * 用来校验支付金额的，如果遇到支付金额是0.1，然后系统金额是0.10，这种情况下金额其实是一致的，但是代码认为不一致
 */
public class MathUtil {
    /**
     * 比较2个金额是否相等
     * @param d1
     * @param d2
     * @return
     */
    private static final Double MONEY_RANGE = 0.01;
    public static Boolean equals(Double d1, Double d2){
        Double result = Math.abs(d1 - d2);
        if(result < MONEY_RANGE){
            return true;
        } else {
            return false;
        }
    }
}

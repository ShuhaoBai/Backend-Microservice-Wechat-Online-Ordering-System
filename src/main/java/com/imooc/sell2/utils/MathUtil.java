package com.imooc.sell2.utils;

/**
 * @author Shuhao Bai on 10/12/19
 */
public class MathUtil {
    /**
     * check if two payment are matching
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

package com.imooc.sell2.VO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * http请求返回的最外层对象
 * Http response of the outer layer objects
 *
 * @author Shuhao Bai on 9/11/19
 */
@Data
public class ResultVO<T> {

    private Integer code;

    private String msg;

    private T data;
}

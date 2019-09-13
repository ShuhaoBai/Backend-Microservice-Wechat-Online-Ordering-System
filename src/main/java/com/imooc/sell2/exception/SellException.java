package com.imooc.sell2.exception;

import com.imooc.sell2.enums.ResultEnum;

/**
 * 异常
 *
 * @author Shuhao Bai on 9/12/19
 */
public class SellException extends RuntimeException {

    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());//把message里的内容传到父类的构造方法里

        this.code = resultEnum.getCode();
    }
}

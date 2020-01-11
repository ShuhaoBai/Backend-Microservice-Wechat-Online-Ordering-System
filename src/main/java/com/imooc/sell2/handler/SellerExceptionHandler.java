package com.imooc.sell2.handler;

import com.imooc.sell2.VO.ResultVO;
import com.imooc.sell2.config.ProjectUrlConfig;
import com.imooc.sell2.exception.SellException;
import com.imooc.sell2.exception.SellerAuthorizeException;
import com.imooc.sell2.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 * 对异常（exception）的捕获和处理
 *
 * @author Shuhao Bai on 10/24/19
 */
@ControllerAdvice
public class SellerExceptionHandler {
    @Autowired
    private ProjectUrlConfig projectUrlConfig;
    //拦截登录异常
    //@org.springframework.web.bind.annotation.ExceptionHandler
    @ExceptionHandler(value = SellerAuthorizeException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ModelAndView handlerAuthorizeException(){
        return new ModelAndView("redirect:"
                .concat(projectUrlConfig.getWechatMpAuthorize())
                .concat("/sell2/wechat/qeAuthorize")
                .concat("?returnUrl=")
                .concat(projectUrlConfig.getSell())
                .concat("/sell2/seller/login"));

    }

    @ExceptionHandler(value = SellException.class)
    @ResponseBody
    public ResultVO handlerSellerExpection(SellException e){
        return ResultVOUtil.error(e.getCode(), e.getMessage());
    }
}

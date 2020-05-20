package com.imooc.sell2.aspect;

import com.imooc.sell2.constant.CookieConstant;
import com.imooc.sell2.constant.RedisConstant;
import com.imooc.sell2.exception.SellException;
import com.imooc.sell2.exception.SellerAuthorizeException;
import com.imooc.sell2.utils.CookieUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * Seller Authentication
 *
 * @author Shuhao Bai on 10/24/19
 */
@Aspect
@Component
@Slf4j
public class SellerAuthorizeAspect {
    @Autowired
    private StringRedisTemplate redisTemplate;

    @Pointcut("execution(public * com.imooc.controller.Seller*.*(..))" + "&& !execution(public * com.imooc.controller.SellerUserCOntroller.*(..))")
    public void verify() {}

    @Before("verify()")
    public void doVerify() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //Search for Cookie
        Cookie cookie = CookieUtil.get(request, CookieConstant.TOKEN);
        if(cookie == null){
            log.warn("【Logging Authentication】 No cookie found in token");
            throw new SellerAuthorizeException();
        }

        //Search in Redis
        String tokenValue = redisTemplate.opsForValue().get(String.format(RedisConstant.TOKEN_PREFIX, cookie.getValue()));
        if(StringUtils.isEmpty(tokenValue)){
            log.warn("【Logging Authentication】No token found in Redis");
            throw new SellerAuthorizeException();
        }
    }
}

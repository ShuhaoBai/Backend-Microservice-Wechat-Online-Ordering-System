package com.imooc.sell2.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 账号信息Config
 *
 * @author Shuhao Bai on 9/25/19
 */

@Data
@Component
@ConfigurationProperties(prefix = "wechat")
public class WechatAccountConfig {
    /**
     * 公众平台id
     */
    private String mpAppId;
    /**
     * 公众平台秘钥
     */
    private String mpAppSecret;
    /**
     * 开放平台id
     */
    private String openAppId;
    /**
     * 开放平台秘钥
     */
    private String openAppSecret;

    /**
     * 商户号
     */
    private String mchId;
    /**
     * 商户秘钥
     */
    private String mchKey;
    private String keyPath;
    //微信支付异步通知地址
    private String notifyUrl;

}

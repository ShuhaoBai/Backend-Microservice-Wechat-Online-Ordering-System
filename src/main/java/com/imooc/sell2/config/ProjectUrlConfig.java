package com.imooc.sell2.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Shuhao Bai on 10/21/19
 */
@Data
@ConfigurationProperties(prefix = "projectUrl")
@Component
public class ProjectUrlConfig {
    public String wechatMpAuthorize;
    public String wechatOpenAuthorize;
    public String sell;
}

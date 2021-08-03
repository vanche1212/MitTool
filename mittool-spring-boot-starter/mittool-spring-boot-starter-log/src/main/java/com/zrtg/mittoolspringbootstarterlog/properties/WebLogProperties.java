package com.zrtg.mittoolspringbootstarterlog.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "mit.weblog")
public class WebLogProperties {

    /**
     * 是否开启日志
     */
    private boolean enable;

    /**
     * 是否启用请求日志
     */
    private boolean request = true;

    /**
     * 是否启用响应日志
     */
    private boolean response = false;

}

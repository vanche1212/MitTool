package com.zrtg.autoconfigure.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "mit.forest-config")
public class MitToolForestConfigurationProperties {

    /**
     * 客户端，默认httpclient
     */
    private String client = "httpclient";

    /**
     * 远程日志是否开启，默认false
     */
    private boolean logEnabled = false;

    /**
     * 响应日志内容是否开启，默认false
     */
    private boolean logResponseContent = false;

}

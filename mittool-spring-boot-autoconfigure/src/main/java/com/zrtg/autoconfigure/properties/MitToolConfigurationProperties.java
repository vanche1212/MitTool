package com.zrtg.autoconfigure.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "mit")
public class MitToolConfigurationProperties {

    /**
     * 请求日志配置
     */
    private WebLogProperties weblog = new WebLogProperties();

    /**
     * RPC配置
     */
    private MitToolForestConfigurationProperties forestConfig = new MitToolForestConfigurationProperties();

    /**
     * 代码自动生成配置
     */
    private MybatisPlusCodeGenerateProperties code = new MybatisPlusCodeGenerateProperties();

}

package com.zrtg.autoconfigure.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "mit")
public class MitToolConfigurationProperties {


    /**
     * Forest配置
     */
    private MitToolForestConfigurationProperties forestConfig = new MitToolForestConfigurationProperties();


}

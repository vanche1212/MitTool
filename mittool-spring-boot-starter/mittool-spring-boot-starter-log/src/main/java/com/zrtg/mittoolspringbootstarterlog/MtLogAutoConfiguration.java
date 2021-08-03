package com.zrtg.mittoolspringbootstarterlog;

import com.zrtg.mittoolcorelog.log.WebLogAspect;
import com.zrtg.mittoolspringbootstarterlog.properties.WebLogProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * 日志配置类
 */
@Configuration
@EnableConfigurationProperties(WebLogProperties.class)
public class MtLogAutoConfiguration {


    @Bean
    @ConditionalOnProperty(prefix = "mit.weblog", value = "enable", matchIfMissing = true)
    public WebLogAspect webLogAspect(WebLogProperties webLogProperties) {
        WebLogAspect webLogAspect = new WebLogAspect();
        webLogAspect.setRequest(webLogProperties.isRequest());
        webLogAspect.setResponse(webLogProperties.isResponse());
        return webLogAspect;
    }


}

package com.zrtg.mittoolspringbootstarterbluecloudapi;


import com.dtflys.forest.config.ForestConfiguration;
import com.dtflys.forest.springboot.ForestBeanRegister;
import com.dtflys.forest.springboot.annotation.ForestScan;
import com.dtflys.forest.springboot.annotation.ForestScannerRegister;
import com.dtflys.forest.ssl.SSLUtils;
import com.zrtg.mittoolspringbootstarterbluecloudapi.properties.MtBlueCloudForestConfigurationProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 中国蓝云接口服务配置类
 */
@Configuration
@ForestScan(basePackages = "com.zrtg.mittoolcorebluecloudapi.client")
//@EnableConfigurationProperties(MtBlueCloudForestConfigurationProperties.class)
public class MtBlueCloudApiAutoConfiguration {



}

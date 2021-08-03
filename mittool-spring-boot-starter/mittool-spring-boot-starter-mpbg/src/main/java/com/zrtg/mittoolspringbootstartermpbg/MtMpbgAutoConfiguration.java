package com.zrtg.mittoolspringbootstartermpbg;

import com.zrtg.mittool.generator.MyBatisPlusGenerator;
import com.zrtg.mittoolspringbootstartermpbg.properties.MybatisPlusCodeGenerateProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * 代码生成配置类
 */
@Configuration
@EnableConfigurationProperties({MybatisPlusCodeGenerateProperties.class})
public class MtMpbgAutoConfiguration {


    @Bean
    @ConditionalOnProperty(prefix = "mit.code", value = "enable", matchIfMissing = false)
    public MyBatisPlusGenerator myBatisPlusGenerator(MybatisPlusCodeGenerateProperties mybatisPlusCodeGenerateProperties) {
        return new MyBatisPlusGenerator(
                mybatisPlusCodeGenerateProperties.getPackageBase(),
                mybatisPlusCodeGenerateProperties.getDatasource().getUrl(),
                mybatisPlusCodeGenerateProperties.getDatasource().getDriverName(),
                mybatisPlusCodeGenerateProperties.getDatasource().getUsername(),
                mybatisPlusCodeGenerateProperties.getDatasource().getPassword());
    }


}

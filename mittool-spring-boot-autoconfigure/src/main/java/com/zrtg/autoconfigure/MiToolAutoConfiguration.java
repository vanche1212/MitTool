package com.zrtg.autoconfigure;

import com.dtflys.forest.config.ForestConfiguration;
import com.dtflys.forest.ssl.SSLUtils;
import com.zrtg.autoconfigure.properties.MybatisPlusCodeGenerateProperties;
import com.zrtg.autoconfigure.properties.MitToolConfigurationProperties;
import com.zrtg.mittool.generator.MyBatisPlusGenerator;
import com.zrtg.mittoolcore.service.MitService;
import com.zrtg.mittoolcore.service.impl.MitServiceImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableConfigurationProperties({MitToolConfigurationProperties.class})
public class MiToolAutoConfiguration {

    @Bean
    @ConditionalOnMissingClass(value={"com.dtflys.forest.springboot.ForestBeanRegister"})
    public ForestConfiguration forestConfiguration(MitToolConfigurationProperties mitToolConfigurationProperties) {
        ForestConfiguration configuration = ForestConfiguration.configuration();
        // configuration.setBackendName("okhttp3");
        configuration.setBackendName(mitToolConfigurationProperties.getForestConfig().getClient());
        // 连接池最大连接数，默认值为500
        configuration.setMaxConnections(123);
        // 每个路由的最大连接数，默认值为500
        configuration.setMaxRouteConnections(222);
        // 请求超时时间，单位为毫秒, 默认值为3000
        configuration.setTimeout(3000);
        // 连接超时时间，单位为毫秒, 默认值为2000
        configuration.setConnectTimeout(2000);
        // 请求失败后重试次数，默认为0次不重试
        configuration.setRetryCount(0);
        // 单向验证的HTTPS的默认SSL协议，默认为SSLv3
        configuration.setSslProtocol(SSLUtils.SSL_3);
        // 打开或关闭日志，默认为true
        configuration.setLogEnabled(mitToolConfigurationProperties.getForestConfig().isLogEnabled());
        // 打开或者关闭响应日志
        configuration.setLogResponseContent(mitToolConfigurationProperties.getForestConfig().isLogResponseContent());
        return configuration;
    }


    @Bean
    @ConditionalOnMissingBean
    public MitService sobeySolarService(ForestConfiguration forestConfiguration) {
        return new MitServiceImpl(forestConfiguration);
    }

    @Bean
    @ConditionalOnProperty(prefix = "mit.code", value = "enable", matchIfMissing = false)
    public MyBatisPlusGenerator myBatisPlusGenerator(MitToolConfigurationProperties mitToolConfigurationProperties) {
        return new MyBatisPlusGenerator(
                mitToolConfigurationProperties.getCode().getPackageBase(),
                mitToolConfigurationProperties.getCode().getDatasource().getUrl(),
                mitToolConfigurationProperties.getCode().getDatasource().getDriverName(),
                mitToolConfigurationProperties.getCode().getDatasource().getUsername(),
                mitToolConfigurationProperties.getCode().getDatasource().getPassword());
    }

}

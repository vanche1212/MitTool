package com.zrtg.autoconfigure.properties;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "mit.code.datasource")
public class MybatisPlusCodeGenerateDataSourceProperties {
    /**
     * 数据库URL
     */
    private String url;
    /**
     * 数据库驱动
     */
    private String driverName;
    /**
     * 账号
     */
    private String username;
    /**
     * 密码
     */
    private String password;



}

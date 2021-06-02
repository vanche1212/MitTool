package com.zrtg.autoconfigure.properties;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Data
@Component
@ConfigurationProperties(prefix = "mit.code")
public class MybatisPlusCodeGenerateProperties {

    /**
     * 是否启用
     */
    private boolean enable = false;

    /**
     * 数据源
     */
    private MybatisPlusCodeGenerateDataSourceProperties datasource;

    /**
     * 代码生成路径（项目基础路径）
     */
    private String packageBase;


}

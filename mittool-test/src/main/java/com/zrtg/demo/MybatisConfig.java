//package com.zrtg.demo;
//
//import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
//import org.apache.ibatis.annotations.Mapper;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.SqlSessionTemplate;
//import org.mybatis.spring.mapper.MapperFactoryBean;
//import org.mybatis.spring.mapper.MapperScannerConfigurer;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//
//import javax.sql.DataSource;
//
//@Configuration
//public class MybatisConfig {
//
//
//
//
////    @Bean
////    public MybatisSqlSessionFactoryBean mybatisSqlSessionFactoryBean() {
////        MybatisSqlSessionFactoryBean mybatis = new MybatisSqlSessionFactoryBean();
////        mybatis.setDataSource(myDataSource());
////        return mybatis;
////    }
//
//
////    @Bean
////    public SqlSessionFactory sqlSessionFactory() throws Exception {
////        MybatisSqlSessionFactoryBean factoryBean = new MybatisSqlSessionFactoryBean();
////        factoryBean.setDataSource(mitDataSource());
////        return factoryBean.getObject();
////    }
////    @Bean
////    public DriverManagerDataSource mitDataSource() {
////        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
////        driverManagerDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
////        driverManagerDataSource.setUrl("jdbc:mysql://10.20.50.133:3306/assessment?useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai");
////        driverManagerDataSource.setUsername("root");
////        driverManagerDataSource.setPassword("123456");
////        return driverManagerDataSource;
////    }
////
////    @Bean
////    public MapperScannerConfigurer mapperScannerConfigurer() {
////        MapperScannerConfigurer configurer = new MapperScannerConfigurer();
////        configurer.setBasePackage("com.zrtg.demo");
//////        configurer.setAnnotationClass(Mapper.class);
////        return configurer;
////    }
//
//
//}

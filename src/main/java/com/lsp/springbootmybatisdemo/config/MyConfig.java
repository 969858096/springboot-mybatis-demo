package com.lsp.springbootmybatisdemo.config;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Properties;

/**
 * @program: springboot-mybatis-demo
 * @description: 配置类信息
 * @author: lsp
 * @create: 2019-12-12 14:54
 * @version:1.0
 **/

@Configuration
public class MyConfig extends WebMvcConfigurerAdapter {
    /*@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX+"/static/");
        super.addResourceHandlers(registry);
    }*/

    /*@Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactoryBean");
        mapperScannerConfigurer.setBasePackage("classpath:mapper");

        //配置通用Mapper，详情请查阅官方文档
        Properties properties = new Properties();
        properties.setProperty("mappers", MAPPER_INTERFACE_REFERENCE);
        properties.setProperty("notEmpty", "true");//insert、update是否判断字符串类型!='' 即 test="str != null"表达式内是否追加 and str != ''

        properties.setProperty("IDENTITY", "SELECT UUID()");//使用UUID作為主鍵
        properties.setProperty("ORDER","BEFORE");//将查询主键作为前置操作

        mapperScannerConfigurer.setProperties(properties);

        return mapperScannerConfigurer;
    }*/
}


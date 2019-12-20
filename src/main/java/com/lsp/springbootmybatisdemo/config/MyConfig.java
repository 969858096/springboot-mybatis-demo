package com.lsp.springbootmybatisdemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @program: springboot-mybatis-demo
 * @description:
 * @author: lsp
 * @create: 2019-12-18 11:45
 * @version:1.0
 **/
@Configuration
public class MyConfig  implements WebMvcConfigurer {
    //模板引擎加载静态资源
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        WebMvcConfigurer.super.addResourceHandlers(registry);
    }

    //springSecurity配置
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/hello").setViewName("hello");
        registry.addViewController("/login").setViewName("login");
    }
}

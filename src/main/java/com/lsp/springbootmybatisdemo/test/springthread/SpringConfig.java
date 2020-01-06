package com.lsp.springbootmybatisdemo.test.springthread;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @FileName: SpringConfig
 * @Description:
 * @AuthOr: lsp
 * @Date: 2020/1/6 20:26
 */
@Configuration
@ComponentScan("com.lsp.springbootmybatisdemo.test")
@EnableAsync
public class SpringConfig {

}

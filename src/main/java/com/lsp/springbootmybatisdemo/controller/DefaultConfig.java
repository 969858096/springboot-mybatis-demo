package com.lsp.springbootmybatisdemo.controller;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

import java.io.IOException;

/**
 * @FileName: DefaultConfig
 * @Description:
 * @AuthOr: lsp
 * @Date: 2019/12/21 21:39
 */
@Configuration
public class DefaultConfig {
    /*@EventListener({ApplicationReadyEvent.class})
    void applicationReadyEvent() {
        System.out.println("应用已经准备就绪 ... 启动浏览器");
        String url = "http://localhost:8888/login";
        Runtime runtime = Runtime.getRuntime();
        try {
            runtime.exec("rundll32 url.dll,FileProtocolHandler " + url);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
}

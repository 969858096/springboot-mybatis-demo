package com.lsp.springbootmybatisdemo.test.springthread;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @FileName: Main
 * @Description:
 * @AuthOr: lsp
 * @Date: 2020/1/6 20:32
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        DemoService bean = annotationConfigApplicationContext.getBean(DemoService.class);
        bean.a();
        bean.b();
    }
}

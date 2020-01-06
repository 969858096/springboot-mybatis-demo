package com.lsp.springbootmybatisdemo.test.springthread;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @FileName: DemoService
 * @Description:
 * @AuthOr: lsp
 * @Date: 2020/1/6 20:29
 */
@Service
public class DemoService {

    @Async
    public void a() throws InterruptedException {
        while (true){
            System.out.println("a");
            Thread.sleep(2000);
        }
    }

    @Async
    public void b() throws InterruptedException {
        while (true){
            System.out.println("b");
            Thread.sleep(2000);
        }
    }
}

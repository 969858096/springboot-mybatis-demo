package com.lsp.springbootmybatisdemo.test.thread.并发队列;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @FileName: ThreadPool
 * @Description:
 * @AuthOr: lsp
 * @Date: 2019/12/28 21:39
 */
public class ThreadPool2 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 30; i++) {
            final int temp = i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+":"+temp);
                }
            });
        }
    }
}

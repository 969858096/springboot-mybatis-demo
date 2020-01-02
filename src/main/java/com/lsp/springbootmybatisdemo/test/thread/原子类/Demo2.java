package com.lsp.springbootmybatisdemo.test.thread.原子类;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: springboot-mybatis-demo
 * @description:
 * @author: lsp
 * @create: 2020-01-02 17:19
 * @version:1.0
 **/
public class Demo2 implements Callable {
    private static Integer count = 1;
    private static AtomicInteger atomic = new AtomicInteger();

    @Override
    public Object call() throws Exception {
        while (true) {
            int count = getCount();
            if (count > 50) {
                break;
            }
        }
        return count;
    }

    public synchronized Integer getCount() {
        try {
            Thread.sleep(50);
        } catch (Exception e) {
            // TODO: handle exception
        }

        return count++;
    }

    public Integer getCountAtomic() {
        try {
            Thread.sleep(50);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return atomic.incrementAndGet();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Demo2 demo2 = new Demo2();
        Future<Integer> future = Executors.newCachedThreadPool().submit(demo2);
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "--" + i);
                }
            }
        });

        System.out.println(future.get());

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + "--" + i);
                }
            }
        });

        t1.start();
        t2.start();
    }

}

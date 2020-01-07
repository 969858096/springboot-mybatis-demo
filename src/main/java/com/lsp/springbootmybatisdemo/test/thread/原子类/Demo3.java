package com.lsp.springbootmybatisdemo.test.thread.原子类;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: springboot-mybatis-demo
 * @description:
 * @author: lsp
 * @create: 2020-01-07 10:33
 * @version:1.0
 **/
public class Demo3 implements Runnable {

    private static AtomicInteger atomicInteger = new AtomicInteger();
    private static int count = 0;

    @Override
    public void run() {
        while (count < 20) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count = atomicInteger.incrementAndGet();//原子类，支持原子性和可见性
            //count++;//volatile只能在原子操作中保证数据安全，他使得共享数据在哥哥线程之间可见且禁止重排序，但是不支持原子性
            System.out.println(count);
        }
    }


    public static void main(String[] args) {
        Demo3 demo3 = new Demo3();
        Thread t1 = new Thread(demo3);
        Thread t2 = new Thread(demo3);
        t1.start();
        t2.start();

    }
}

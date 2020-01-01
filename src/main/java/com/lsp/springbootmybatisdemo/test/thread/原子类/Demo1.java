package com.lsp.springbootmybatisdemo.test.thread.原子类;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: springboot-mybatis-demo
 * @description:
 * @author: lsp
 * @create: 2019-12-31 16:33
 * @version:1.0
 **/
class AtimocTest extends Thread {
    private static final Logger log = LoggerFactory.getLogger(AtimocTest.class);
    private static AtomicInteger atomicInteger = new AtomicInteger();
    private Lock lock = new ReentrantLock();
    @Override
    public void run() {
        int a = 0;
       while (a < 20){
           lock.lock();
           try {
               Thread.sleep(1000);//使得两个线程都有足够的时间去获取cpu资源
               a = atomicInteger.incrementAndGet();
               log.info(Thread.currentThread().getName() + "---a=" + a);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           lock.unlock();
       }
    }
}

public class Demo1 {
    public static void main(String[] args) {
        AtimocTest atimocTest = new AtimocTest();
        AtimocTest atimocTest1 = new AtimocTest();
        atimocTest.start();
        atimocTest1.start();

        Executors.newCachedThreadPool();

    }
}
package com.lsp.springbootmybatisdemo.test.thread.重入锁;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: springboot-mybatis-demo
 * @description:重入锁 synchronized
 * @author: lsp
 * @create: 2020-01-02 13:58
 * @version:1.0
 **/
public class Demo implements Runnable {

    @Override
    public void run() {
        get();
    }

    public synchronized void get(){
        System.out.println(Thread.currentThread().getName()+"get()");
        set();
    }

    public synchronized void set(){
        System.out.println(Thread.currentThread().getName()+"set()");
    }

    public static void main(String[] args) {
       Thread t = new Thread(new Demo());
       t.start();
    }


    Lock lock = new ReentrantLock();
}

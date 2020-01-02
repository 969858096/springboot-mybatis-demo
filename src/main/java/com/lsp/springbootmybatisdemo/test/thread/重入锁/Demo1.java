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
public class Demo1 implements Runnable {
  private Lock lock = new ReentrantLock();
    @Override
    public void run() {
        get();
    }

    public  void get(){
        lock.lock();
        System.out.println(Thread.currentThread().getName()+"get()");
        set();
        lock.unlock();
    }

    public  void set(){
        lock.lock();
        System.out.println(Thread.currentThread().getName()+"set()");
        lock.unlock();
    }

    public static void main(String[] args) {
       Thread t = new Thread(new Demo1());
       t.start();
    }
}

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
public class Demo2 implements Runnable {
    private static Lock lock = new ReentrantLock();
    private static int money;

    public Demo2(Integer money) {
        this.money = money;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"线程开启");
        while (true){
            save();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            get();
        }
    }

    //存款
    public void save()   {
        lock.lock();
        money++;
        System.out.println(Thread.currentThread().getName()+"存钱+1--余额="+money);
        lock.unlock();
    }
    //取钱
    public void get(){
        lock.lock();
        money--;
        System.out.println(Thread.currentThread().getName()+"取钱-1,余额="+money);
        lock.unlock();
    }

    public static void main(String[] args) {
        Demo2 demo2 = new Demo2(50);
        Thread t = new Thread(demo2);
        Thread t2 = new Thread(demo2);
        Thread t3 = new Thread(demo2);
        t.start();
        t2.start();
        t3.start();
    }
}

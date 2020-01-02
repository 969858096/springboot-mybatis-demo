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
public class Demo3 implements Runnable {
    private static Lock lock = new ReentrantLock();
    private static int money;
    private static boolean flag = true;

    public Demo3(Integer money) {
        this.money = money;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"线程开启");

    }

    //存款
    public void save()   {
       while (flag){
           lock.lock();
           money++;
           System.out.println(Thread.currentThread().getName()+"存钱+1--余额="+money);
           lock.unlock();
       }
    }
    //取钱
    public void get(){
        while (!flag){
            lock.lock();
            money--;
            System.out.println(Thread.currentThread().getName()+"取钱-1,余额="+money);
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Demo3 demo2 = new Demo3(50);
        Thread t = new Thread(demo2);
        Thread t2 = new Thread(demo2);
        Thread t3 = new Thread(demo2);
        t.start();
        t2.start();
        t3.start();
    }
}

package com.lsp.springbootmybatisdemo.test;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: springboot-mybatis-demo
 * @description:
 * @author: lsp
 * @create: 2019-12-31 11:02
 * @version:1.0
 **/

class MyThreadDemo implements Runnable {
    private static int tickets = 100;
    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while (tickets > 0) {
            lock.lock();
            System.out.println("《当前窗口是：" + Thread.currentThread().getName()+"》");
            try {
                if (tickets == 0){
                    System.out.println("票已经卖完！！！");
                    lock.unlock();
                    break;
                }
                tickets--;
                Thread.currentThread().sleep(50);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "卖票1张" + "，余票=" + tickets);
            lock.unlock();
        }

    }

}

public class LockDemo {
    public static void main(String[] args) {
       /* MyThreadDemo myThreadDemo = new MyThreadDemo();
        Thread thread1 = new Thread(myThreadDemo, "窗口1");
        Thread thread2 = new Thread(myThreadDemo, "窗口2");
        Thread thread3 = new Thread(myThreadDemo, "窗口3");
        thread1.start();
        thread2.start();
        thread3.start();*/

        SynchronousQueue s = new  SynchronousQueue();
         boolean flag =s.offer(1);
         Object o1 = s.poll();
        System.out.println(o1);
        System.out.println(flag);
        Iterator iterator = s.iterator();
        while (iterator.hasNext()){
            Object o = iterator.next();
            System.out.println(o);
        }
    }
}

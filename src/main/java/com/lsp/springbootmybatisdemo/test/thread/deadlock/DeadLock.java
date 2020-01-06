package com.lsp.springbootmybatisdemo.test.thread.deadlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @FileName: DeadLock
 * @Description:
 * @AuthOr: lsp
 * @Date: 2020/1/6 23:17
 */
public class DeadLock  {
    private Object object = new Object();
    private Object object1 = new Object();



    public void a() throws InterruptedException {
        synchronized (object){
            Thread.sleep(10);
            synchronized (object1){
                System.out.println("方法a");
            }
        }
    }

    public void b() throws InterruptedException {
        synchronized (object1){
            Thread.sleep(10);
            synchronized (object){
                System.out.println("方法b");
            }
        }
    }

    public static void main(String[] args) {
        DeadLock deadLock = new DeadLock();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    deadLock.a();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    deadLock.b();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();


    }


}

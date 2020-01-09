package com.lsp.springbootmybatisdemo.test.thread.aqs;

/**
 * @FileName: Main
 * @Description:
 * @AuthOr: lsp
 * @Date: 2020/1/8 21:42
 */
public class Main {
    private int value;
    MyLock myLock = new MyLock();

    public int next()   {
        myLock.lock();
        try {
            Thread.sleep(1000);
            return value++;
        } catch (InterruptedException e) {
            throw  new RuntimeException();
        }finally {
           myLock.unlock();
        }
    }


    public static void main(String[] args) {
        Main main = new Main();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    System.out.println("当前线程"+Thread.currentThread().getName()+":"+main.next());
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    System.out.println("当前线程"+Thread.currentThread().getName()+":"+main.next());
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    System.out.println("当前线程"+Thread.currentThread().getName()+":"+main.next());
                }
            }
        }).start();
    }
}

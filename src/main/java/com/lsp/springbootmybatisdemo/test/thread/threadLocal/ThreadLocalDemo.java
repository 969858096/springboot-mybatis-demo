package com.lsp.springbootmybatisdemo.test.thread.threadLocal;

/**
 * @program: springboot-mybatis-demo
 * @description:
 * @author: lsp
 * @create: 2020-01-07 11:42
 * @version:1.0
 **/
public class ThreadLocalDemo {
    private static ThreadLocal<Integer> threadLocal = new ThreadLocal();
    private static int count;

    public void set() {
        while (count < 10) {
            threadLocal.set(1);
            count++;
        }
    }

    public Integer get() {
        return threadLocal.get();
    }


    public static void main(String[] args) {
        ThreadLocalDemo threadLocalDemo = new ThreadLocalDemo();
        new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocalDemo.set();
                System.out.println(threadLocalDemo.get());
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocalDemo.set();
                System.out.println(threadLocalDemo.get());
            }
        }).start();
    }
}

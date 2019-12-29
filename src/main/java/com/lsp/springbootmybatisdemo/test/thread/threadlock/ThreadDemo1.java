package com.lsp.springbootmybatisdemo.test.thread.threadlock;

/**
 * @FileName: ThreadDemo1
 * @Description:
 * @AuthOr: lsp
 * @Date: 2019/12/28 16:31
 */

class Share {
    public static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>() {
        protected Integer initialValue() {
            return 0;
        }
    };

    public Integer getNumber() {
        int count = threadLocal.get() + 1;
        threadLocal.set(count);
        return count;
    }

}

public class ThreadDemo1 extends Thread {

    private Share share;

    public ThreadDemo1(Share share) {
        this.share = share;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println(this.currentThread().getName() + "," + i);
        }
    }


    public static void main(String[] args) {
        Share share = new Share();
        ThreadDemo1 threadDemo1 = new ThreadDemo1(share);
        ThreadDemo1 threadDemo2 = new ThreadDemo1(share);

        threadDemo1.start();
        threadDemo2.start();
    }
}

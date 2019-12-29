package com.lsp.springbootmybatisdemo.test.thread.并发队列;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @FileName: ThreadPool
 * @Description:
 * @AuthOr: lsp
 * @Date: 2019/12/28 21:39
 */
class MyThreadPool{
    private static int POOL_SIZE;
    private static BlockingQueue blockingQueue = new LinkedBlockingDeque(POOL_SIZE);

    public MyThreadPool(int POOL_SIZE) {
        this.POOL_SIZE = POOL_SIZE;
        for (int i = 0; i < POOL_SIZE; i++) {
            Thread thread = new Thread();
            blockingQueue.offer(thread);
        }
    }
}


public class ThreadPool3 {
    public static void main(String[] args) {

    }
}

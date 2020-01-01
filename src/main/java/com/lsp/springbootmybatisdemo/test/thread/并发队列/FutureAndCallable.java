package com.lsp.springbootmybatisdemo.test.thread.并发队列;


import java.util.TreeSet;
import java.util.concurrent.*;

/**
 * @FileName: FutureAndCallable
 * @Description:
 * @AuthOr: lsp
 * @Date: 2019/12/29 21:13
 */
public class FutureAndCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future submit = executorService.submit(new TaskCallable());
        Object o = submit.get();
        System.out.println("result="+o);


    }
}

class TaskCallable implements Callable {

    @Override
    public String call() throws InterruptedException {
        System.out.println("正在执行子线程任务，需要等待5秒");
       Thread.sleep(5000);
        System.out.println("子线程任务执行结束，任务结束");
        return "lsp";
    }
}

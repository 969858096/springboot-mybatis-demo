package com.lsp.springbootmybatisdemo.test.thread.并发队列;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: springboot-mybatis-demo
 * @description:
 * @author: lsp
 * @create: 2019-12-31 15:24
 * @version:1.0
 **/
class ProducterThread implements Runnable{
    private static final Logger log = LoggerFactory.getLogger(ProducterThread.class);
    private BlockingQueue<String> blockingQueue;
    private AtomicInteger count = new AtomicInteger();
    private volatile boolean flag = true;

    public ProducterThread(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        log.info(Thread.currentThread().getName()+"开始生产...");
        while (flag){
            String data = count.incrementAndGet()+"";
            try {
               boolean offer = blockingQueue.offer(data,2, TimeUnit.SECONDS);
               if (offer){
                   log.info(Thread.currentThread().getName()+"生产线"+"生产数据成功，data="+data);
               }else {
                   log.info(Thread.currentThread().getName()+"生产线"+"生产数据失败,data="+data);
               }
               Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        log.info("生产线停止生产");
    }
}

class ComsumerThread1 implements Runnable{
    private static final Logger log = LoggerFactory.getLogger(ProducterThread.class);
    private BlockingQueue<String> blockingQueue;
    private AtomicInteger count = new AtomicInteger();
    private volatile boolean flag = true;

    public ComsumerThread1(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        log.info(Thread.currentThread().getName()+"开始消费...");
        while (flag){
            try {
                String data = blockingQueue.poll(2,TimeUnit.SECONDS);
                if (data == null || data.equals("")){
                    flag = false;
                    log.info("消费者超过两秒未获取到数据");
                    return;
                }else {
                    log.info(Thread.currentThread().getName()+"消费线"+"消费数据成功，data="+data);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        log.info("消费线停止");
    }
}
public class BlockingQueueDemo {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        Thread producter = new Thread(new ProducterThread(blockingQueue));
        Thread consumer = new Thread(new ComsumerThread1(blockingQueue));
        producter.start();
        consumer.start();
    }
}

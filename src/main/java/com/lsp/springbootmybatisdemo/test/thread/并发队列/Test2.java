package com.lsp.springbootmybatisdemo.test.thread.并发队列;

import org.apache.commons.lang.StringUtils;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @FileName: Test2
 * @Description:
 * @AuthOr: lsp
 * @Date: 2019/12/28 20:15
 */
//生产者
class ProducerThread implements Runnable {
    private BlockingQueue<String> blockingQueue;
    private volatile boolean FLAG = true;
    AtomicInteger atomicInteger = new AtomicInteger();

    public ProducerThread(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        System.out.println("生产者开始生产");
        while (FLAG) {
            try {
                String data = atomicInteger.incrementAndGet() + "";

                boolean offer = blockingQueue.offer(data, 2, TimeUnit.SECONDS);//满了阻塞2秒
                if (offer) {
                    System.out.println("生产者存入成功，data=" + data);
                } else {
                    System.out.println("生产者存入失败，data=" + data);
                }
            } catch (Exception e) {
                System.out.println("生产异常");
            } finally {
                System.out.println("生产者已经生产结束。。。");
            }
        }
    }

    public void stop() {
        this.FLAG = false;
    }
}

//消费者
class ComsumerThread implements Runnable {
    private BlockingQueue<String> blockingQueue;
    private volatile boolean FLAG = true;
    AtomicInteger atomicInteger = new AtomicInteger();

    public ComsumerThread(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        System.out.println("消费者开始消费");
        while (FLAG) {
            try {
                String poll = blockingQueue.poll(2, TimeUnit.SECONDS);
                if (StringUtils.isNotBlank(poll)) {
                    System.out.println("消费者消费成功，data=" + blockingQueue.size());
                } else {
                    System.out.println("消费者消费失败，data=" + blockingQueue.size());
                    FLAG = false;
                }
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println("消费异常");
            } finally {
                System.out.println("消费者已经消费结束。。。");
            }
        }
    }
}


public class Test2 {
    public static void main(String[] args) throws InterruptedException {
        /*BlockingQueue<String> datas = new LinkedBlockingDeque<>(10);
        ProducerThread producerThread = new ProducerThread(datas);
        ComsumerThread comsumerThread = new ComsumerThread(datas);

        Thread thread1 = new Thread(producerThread,"生产者");
        Thread thread2 = new Thread(comsumerThread,"消费者");
        thread1.start();
        thread2.start();

        Thread.sleep(10 * 1000);

        producerThread.stop();*/
        while (true){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("创建线程:"+Thread.currentThread().getName());
                }
            }).start();
        }
    }
}

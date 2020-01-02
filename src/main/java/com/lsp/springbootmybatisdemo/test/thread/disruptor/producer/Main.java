package com.lsp.springbootmybatisdemo.test.thread.disruptor.producer;

import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import com.lsp.springbootmybatisdemo.test.thread.disruptor.consumer.LongEvenHandler;
import com.lsp.springbootmybatisdemo.test.thread.disruptor.consumer.LongEvenHandler2;
import com.lsp.springbootmybatisdemo.test.thread.disruptor.entity.LongEven;
import com.lsp.springbootmybatisdemo.test.thread.disruptor.factory.LongEvenFactory;

import java.nio.ByteBuffer;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @FileName: Main
 * @Description:
 * @AuthOr: lsp
 * @Date: 2020/1/1 16:21
 */
public class Main {
    public static void main(String[] args) {
        //创建可缓存的线程池，提供推送给consumer消费的数据
        ExecutorService threadPool = Executors.newCachedThreadPool();
        //创建工厂
        EventFactory<LongEven> longEvenFactory = new LongEvenFactory();
        //创建ringBuffer大小
        int ringBufferSize = 1024*1024;//方便取模，大小要是2^n
        //创建Disruptor
        Disruptor<LongEven> longEvenDisruptor = new Disruptor<>(longEvenFactory, ringBufferSize, threadPool, ProducerType.MULTI,new YieldingWaitStrategy());
        //连接消费者，注册消费者,就是给哪个消费者连接，给谁推送消息,,多个消费者 默认是重复消费模式
        longEvenDisruptor.handleEventsWith(new LongEvenHandler());
        longEvenDisruptor.handleEventsWith(new LongEvenHandler2());
        //启动disruptor
        longEvenDisruptor.start();
        //获取RingBuffer容器
        RingBuffer<LongEven> ringBuffer = longEvenDisruptor.getRingBuffer();
        //创建生产者
        LongEvenProducer longEvenProducer = new LongEvenProducer(ringBuffer);
        //指定缓冲区的大小
        ByteBuffer byteBuffer = ByteBuffer.allocate(8);
        for (int i = 0; i < 100; i++) {
            byteBuffer.putLong(0,i);
            longEvenProducer.onData(byteBuffer);
        }
        longEvenDisruptor.shutdown();


    }
}

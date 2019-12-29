package com.lsp.springbootmybatisdemo.test.thread.并发队列;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @FileName: BlockingQueueTest
 * @Description:
 * @AuthOr: lsp
 * @Date: 2019/12/28 20:00
 */
public class BlockingQueueTest {
    public static void main(String[] args) {
        ArrayBlockingQueue<Object> objects = new ArrayBlockingQueue<>(3);
        objects.add(1);
        objects.add(2);
        objects.add(3);
        System.out.println(objects.size());
        System.out.println(objects.poll());
        System.out.println(objects.size());
    }
}

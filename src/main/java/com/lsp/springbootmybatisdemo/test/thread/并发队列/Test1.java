package com.lsp.springbootmybatisdemo.test.thread.并发队列;

import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * @FileName: Test1
 * @Description:
 * @AuthOr: lsp
 * @Date: 2019/12/28 19:49
 */
public class Test1 {
    public static void main(String[] args) {
        //非阻塞式队列
        ConcurrentLinkedDeque<Integer> objects = new ConcurrentLinkedDeque<>();
        objects.add(1);
        objects.add(2);
        objects.add(3);
        Integer poll = objects.poll();
        System.out.println(poll);
        System.out.println(objects.size());
        objects.add(4);
        System.out.println(objects.size());
        System.out.println(objects.getLast());
    }
}

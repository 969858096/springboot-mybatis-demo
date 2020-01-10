package com.lsp.springbootmybatisdemo.test.设计模式.抽象工厂.chairEntity;

import com.lsp.springbootmybatisdemo.test.设计模式.抽象工厂.interfaces.Chair;

/**
 * @FileName: ChairA
 * @Description:
 * @AuthOr: lsp
 * @Date: 2020/1/10 21:26
 */
public class ChairA implements Chair {
    public ChairA() {
        System.out.println("座椅A");
    }

    @Override
    public void run() {
        System.out.println("座椅A,很舒服，但是价格贵");
    }
}

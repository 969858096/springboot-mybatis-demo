package com.lsp.springbootmybatisdemo.test.设计模式.工厂模式.抽象工厂.chairEntity;

import com.lsp.springbootmybatisdemo.test.设计模式.工厂模式.抽象工厂.interfaces.Chair;

/**
 * @FileName: ChairA
 * @Description:
 * @AuthOr: lsp
 * @Date: 2020/1/10 21:26
 */
public class ChairB implements Chair {
    public ChairB() {
        System.out.println("座椅B");
    }

    @Override
    public void run() {
        System.out.println("座椅B,不是很舒服，但是价格相对便宜");
    }
}

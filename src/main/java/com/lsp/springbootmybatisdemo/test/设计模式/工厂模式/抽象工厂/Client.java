package com.lsp.springbootmybatisdemo.test.设计模式.工厂模式.抽象工厂;

import com.lsp.springbootmybatisdemo.test.设计模式.工厂模式.抽象工厂.interfaces.Chair;
import com.lsp.springbootmybatisdemo.test.设计模式.工厂模式.抽象工厂.interfaces.Engine;

/**
 * @FileName: Client
 * @Description:
 * @AuthOr: lsp
 * @Date: 2020/1/10 21:43
 */
public class Client {
    public static void main(String[] args) {
        BYDFactory bydFactory = new BYDFactory();
        Chair chair = bydFactory.makeChair("chairA");
        Engine engine = bydFactory.makeEngine("engineA");
    }
}

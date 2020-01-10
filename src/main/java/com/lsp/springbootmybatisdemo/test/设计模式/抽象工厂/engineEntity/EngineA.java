package com.lsp.springbootmybatisdemo.test.设计模式.抽象工厂.engineEntity;

import com.lsp.springbootmybatisdemo.test.设计模式.抽象工厂.interfaces.Engine;

/**
 * @FileName: EngineA
 * @Description:
 * @AuthOr: lsp
 * @Date: 2020/1/10 21:22
 */

public class EngineA implements Engine {
    public EngineA() {
        System.out.println("发动机A");
    }

    @Override
    public void run() {
        System.out.println("发动机A转速块。。。");
    }
}

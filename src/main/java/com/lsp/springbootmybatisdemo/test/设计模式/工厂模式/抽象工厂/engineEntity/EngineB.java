package com.lsp.springbootmybatisdemo.test.设计模式.工厂模式.抽象工厂.engineEntity;

import com.lsp.springbootmybatisdemo.test.设计模式.工厂模式.抽象工厂.interfaces.Engine;

/**
 * @FileName: EngineA
 * @Description:
 * @AuthOr: lsp
 * @Date: 2020/1/10 21:22
 */

public class EngineB implements Engine {
    public EngineB() {
        System.out.println("发动机B");
    }

    @Override
    public void run() {
        System.out.println("发动机B转速慢");
    }
}

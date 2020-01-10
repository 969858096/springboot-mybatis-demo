package com.lsp.springbootmybatisdemo.test.设计模式.抽象工厂;

import com.lsp.springbootmybatisdemo.test.设计模式.抽象工厂.interfaces.Chair;
import com.lsp.springbootmybatisdemo.test.设计模式.抽象工厂.interfaces.Engine;

/**
 * @FileName: CarFactory
 * @Description: 车零件厂
 * @AuthOr: lsp
 * @Date: 2020/1/10 21:29
 */
public interface CarFactory{
    //创建发动机
    Engine makeEngine(String name);
    //创建座椅
    Chair makeChair(String name);

}

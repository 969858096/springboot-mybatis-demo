package com.lsp.springbootmybatisdemo.test.设计模式.工厂模式.工厂方法模式;

/**
 * @FileName: CarFactory
 * @Description: 汽车厂（4S店），什么车都卖
 * @AuthOr: lsp
 * @Date: 2020/1/10 20:35
 */

public interface CarFactory {
      Car makeCar(String carName);
}

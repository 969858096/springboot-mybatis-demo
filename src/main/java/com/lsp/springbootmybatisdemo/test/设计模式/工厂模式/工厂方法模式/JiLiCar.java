package com.lsp.springbootmybatisdemo.test.设计模式.工厂模式.工厂方法模式;

/**
 * @FileName: JiLiCar
 * @Description: 比亚迪 生产厂
 * @AuthOr: lsp
 * @Date: 2020/1/10 20:32
 */
public class JiLiCar  implements Car {
    public JiLiCar() {
        System.out.println("这就是吉利");
    }

    @Override
    public void run() {
        System.out.println("吉利车");
    }
}

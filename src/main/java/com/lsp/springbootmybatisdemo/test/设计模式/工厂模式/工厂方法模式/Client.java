package com.lsp.springbootmybatisdemo.test.设计模式.工厂模式.工厂方法模式;

/**
 * @FileName: Client
 * @Description:
 * @AuthOr: lsp
 * @Date: 2020/1/10 20:34
 */
public class Client {
    public static void main(String[] args) {
        BYDFactory bydFactory = new BYDFactory();
        bydFactory.makeCar("比亚迪");

        JiliFactory jiliFactory = new JiliFactory();
        jiliFactory.makeCar("吉利");
    }
}

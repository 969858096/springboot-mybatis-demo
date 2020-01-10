package com.lsp.springbootmybatisdemo.test.设计模式.简单工厂模式;

/**
 * @FileName: BYD
 * @Description: 比亚迪汽车
 * @AuthOr: lsp
 * @Date: 2020/1/10 20:31
 */
public class BYD implements Car {

    public BYD(){
        System.out.println("这就是比亚迪");
    }
    @Override
    public void run() {
        System.out.println("比亚迪汽车");
    }
}

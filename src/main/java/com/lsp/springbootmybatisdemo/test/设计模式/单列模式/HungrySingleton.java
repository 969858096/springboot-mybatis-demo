package com.lsp.springbootmybatisdemo.test.设计模式.单列模式;

/**
 * @FileName: HungrySingleton
 * @Description: 类在初始化的时候就会创建对象 饿汉式单列模式，天生安全，效率高。不使用对象的时候会浪费内存
 * @AuthOr: lsp
 * @Date: 2020/1/9 22:03
 */
public class HungrySingleton {

    private static final HungrySingleton hungrySingleton = new HungrySingleton();

    //将构造函数私有化
    private HungrySingleton(){

    }

    //对外提供创建实例的方法
    public static HungrySingleton getInstance(){
        return hungrySingleton;
    }

    public static void main(String[] args) {
        HungrySingleton instance1 = HungrySingleton.getInstance();
        HungrySingleton instance2 = HungrySingleton.getInstance();
        System.out.println(instance1 == instance2);
    }

}

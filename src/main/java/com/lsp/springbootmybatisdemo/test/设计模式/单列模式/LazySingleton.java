package com.lsp.springbootmybatisdemo.test.设计模式.单列模式;

/**
 * @FileName: LazySingleton
 * @Description:  懒汉式单列模式，类初始化的时候不会创建对象，使用到的时候才创建实例；天生多线程不安全，手动加锁解决线程安全问题，所以效率相对较低
 * @AuthOr: lsp
 * @Date: 2020/1/9 22:13
 */
public class LazySingleton {
    private static LazySingleton lazySingleton;

    private LazySingleton(){

    }
    //为保证线程安全，所以加锁，所以会影响效率
    public static synchronized LazySingleton getInstance(){
        if (lazySingleton == null){
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }

    public static void main(String[] args) {
        LazySingleton lazySingleton1 = LazySingleton.getInstance();
        LazySingleton lazySingleton2 = LazySingleton.getInstance();
        System.out.println(lazySingleton1 == lazySingleton2);
    }
}

package com.lsp.springbootmybatisdemo.test.设计模式.单列模式;

/**
 * @FileName: InnerClassSingleton
 * @Description: 静态内部类方式创建单列模式
 * @AuthOr: lsp
 * @Date: 2020/1/9 23:16
 */
public class InnerClassSingleton {

    private InnerClassSingleton(){

    }
    //方法没有同步，效率相对较高
    public static InnerClassSingleton getInstance(){
        System.out.println("getInstance");
        return SingletonInstance.innerClassSingleton;
    }

    public static class SingletonInstance{
        private static final InnerClassSingleton innerClassSingleton = new InnerClassSingleton();
    }



    public static void main(String[] args) {
        InnerClassSingleton instance1 = InnerClassSingleton.getInstance();
        InnerClassSingleton instance2 = InnerClassSingleton.getInstance();
        System.out.println(instance1 == instance2);
    }
}

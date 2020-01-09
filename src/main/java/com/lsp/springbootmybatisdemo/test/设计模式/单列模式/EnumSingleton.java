package com.lsp.springbootmybatisdemo.test.设计模式.单列模式;
//枚举单列模式
public class EnumSingleton {

    EnumSingleton() {
    }

    public static EnumSingleton getInstance(){
        return getEnumSingletonInstance.INSTANCE.getInstance();
    }

    //定义枚举
    static enum getEnumSingletonInstance {
        INSTANCE;
        private EnumSingleton enumSingleton;
        getEnumSingletonInstance() {
            enumSingleton = new EnumSingleton();
        }

        public EnumSingleton getInstance(){
            return this.enumSingleton;
        }
    }

    public static void main(String[] args) {
        EnumSingleton instance = EnumSingleton.getInstance();
        EnumSingleton instance1 = EnumSingleton.getInstance();
        System.out.println(instance == instance1);
    }
}

package com.lsp.springbootmybatisdemo.test.设计模式.单列模式;

import javafx.util.converter.DoubleStringConverter;

/**
 * @FileName: DoubleCheckLockSingleton
 * @Description: 双重检验锁 创建单列内模式：
 * @AuthOr: lsp
 * @Date: 2020/1/9 22:57
 */
public class DoubleCheckLockSingleton {

    private static DoubleCheckLockSingleton doubleCheckLockSingleton;

    private DoubleCheckLockSingleton() {

    }

    //当要创建对象的时候才加锁  （会存在重排序问题）
    public static DoubleCheckLockSingleton getInstance() {
        if (doubleCheckLockSingleton == null) {
            synchronized (DoubleStringConverter.class) {
                if (doubleCheckLockSingleton == null) {
                    doubleCheckLockSingleton = new DoubleCheckLockSingleton();
                }
            }
        }
        return doubleCheckLockSingleton;
    }


    public static void main(String[] args) {
        DoubleCheckLockSingleton doubleCheckLockSingleton = DoubleCheckLockSingleton.getInstance();
        DoubleCheckLockSingleton doubleCheckLockSingleton1 = DoubleCheckLockSingleton.getInstance();
        System.out.println(doubleCheckLockSingleton == doubleCheckLockSingleton1);
    }
}

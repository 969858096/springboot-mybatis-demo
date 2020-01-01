package com.lsp.springbootmybatisdemo.test;

/**
 * @program: springboot-mybatis-demo
 * @description:
 * @author: lsp
 * @create: 2019-12-27 17:06
 * @version:1.0
 **/
public class classLoadTest {
    public static void main(String[] args) {
        MyClassLoad myClassLoad = new MyClassLoad("D:\\GitExtensions\\springboot-mybatis-demo\\target\\classes\\com\\lsp\\springbootmybatisdemo\\test\\");
        try {
            Class clazz = myClassLoad.findClass("HelloWorld");
            System.out.println(clazz);
            System.out.println(clazz.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

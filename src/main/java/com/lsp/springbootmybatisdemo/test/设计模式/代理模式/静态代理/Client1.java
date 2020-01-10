package com.lsp.springbootmybatisdemo.test.设计模式.代理模式.静态代理;

import org.springframework.boot.test.context.SpringBootTest;

/**
 * @FileName: Client1
 * @Description:
 * @AuthOr: lsp
 * @Date: 2020/1/10 22:02
 */
@SpringBootTest
public class Client1 {
    public static void main(String[] args) {
        //未使用代理对象的时候
        /*UserDaoImpl userDao = new UserDaoImpl();
        userDao.add();*/

        //使用代理对象
        UserDaoProxy userDaoProxy = new UserDaoProxy(new UserDaoImpl());
        userDaoProxy.add();
    }
}

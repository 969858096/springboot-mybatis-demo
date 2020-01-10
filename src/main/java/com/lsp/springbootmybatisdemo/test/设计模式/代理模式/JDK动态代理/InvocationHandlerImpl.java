package com.lsp.springbootmybatisdemo.test.设计模式.代理模式.JDK动态代理;

import com.lsp.springbootmybatisdemo.impl.UserImpl;
import com.lsp.springbootmybatisdemo.test.设计模式.代理模式.静态代理.UserDao;
import com.lsp.springbootmybatisdemo.test.设计模式.代理模式.静态代理.UserDaoImpl;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @FileName: InvocationHandlerImpl
 * @Description: jdk动态代理
 * @AuthOr: lsp
 * @Date: 2020/1/10 22:25
 */
@Slf4j
public class InvocationHandlerImpl implements InvocationHandler {
    //传放入代理对象
    private Object object;

    public InvocationHandlerImpl(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log.info("开启事务");
        Object invoke = method.invoke(object, args);
        log.info("提交事务");
        return invoke;
    }


    public static void main(String[] args) {
        UserDao userDao = new UserDaoImpl();
        ClassLoader classLoader = userDao.getClass().getClassLoader();
        Class<?>[] interfaces = userDao.getClass().getInterfaces();
        InvocationHandlerImpl invocationHandler = new InvocationHandlerImpl(userDao);
        Object o = Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
        if (o instanceof UserDao) {
            UserDao userDao1 = (UserDao) o;
            userDao1.add();
        }
    }
}

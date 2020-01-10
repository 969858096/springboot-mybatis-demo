package com.lsp.springbootmybatisdemo.test.设计模式.代理模式.cglib动态代理;

import com.lsp.springbootmybatisdemo.test.设计模式.代理模式.静态代理.UserDao;
import com.lsp.springbootmybatisdemo.test.设计模式.代理模式.静态代理.UserDaoImpl;
import lombok.extern.slf4j.Slf4j;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @FileName: CglibProxy
 * @Description:
 * @AuthOr: lsp
 * @Date: 2020/1/10 22:44
 */
@Slf4j
public class CglibProxy implements MethodInterceptor {

    private Object object;

    public Object getInstance(Object object){
        this.object = object;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(object.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        log.info("开启事务");
        Object invoke = methodProxy.invoke(object, objects);
        log.info("提交事务");
        return invoke;
    }

    public static void main(String[] args) {
        CglibProxy cglibProxy = new CglibProxy();
        UserDaoImpl instance = (UserDaoImpl) cglibProxy.getInstance(new UserDaoImpl());
        instance.add();

    }
}

package com.lsp.springbootmybatisdemo.test.设计模式.代理模式.静态代理;

import lombok.extern.slf4j.Slf4j;

/**
 * @FileName: UserDaoProxy
 * @Description:
 * @AuthOr: lsp
 * @Date: 2020/1/10 22:05
 */
@Slf4j
public class UserDaoProxy implements UserDao {
    private UserDaoImpl userDao;

    public UserDaoProxy(UserDaoImpl userDao) {
        this.userDao = userDao;
    }

    @Override
    public void add() {
        log.info("开启事务");
        userDao.add();
        log.info("提交事务");
    }
}

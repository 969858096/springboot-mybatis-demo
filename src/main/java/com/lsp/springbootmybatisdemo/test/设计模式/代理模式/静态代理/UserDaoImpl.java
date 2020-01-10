package com.lsp.springbootmybatisdemo.test.设计模式.代理模式.静态代理;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UserDaoImpl implements UserDao {
    public void add() {
        log.info("。。。UserDao>>add方法。。。");
    }
}

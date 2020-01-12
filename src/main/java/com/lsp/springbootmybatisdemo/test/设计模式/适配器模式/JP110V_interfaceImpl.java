package com.lsp.springbootmybatisdemo.test.设计模式.适配器模式;

import lombok.extern.slf4j.Slf4j;

/**
 * @FileName: JP110V_interfaceImpl
 * @Description:
 * @AuthOr: lsp
 * @Date: 2020/1/12 14:05
 */
@Slf4j
public class JP110V_interfaceImpl implements JP110V_interface {
    @Override
    public void connect() {
      log.info("连接上日本110V电源-----");
    }
}

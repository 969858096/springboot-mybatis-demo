package com.lsp.springbootmybatisdemo.test.设计模式.适配器模式;

import lombok.extern.slf4j.Slf4j;

/**
 * @FileName: CN220V_interfaceImpl
 * @Description:
 * @AuthOr: lsp
 * @Date: 2020/1/12 14:07
 */
@Slf4j
public class CN220V_interfaceImpl implements CN220V_interface {
    @Override
    public void connect() {
      log.info("已经连接上中国220V电源---");
    }
}

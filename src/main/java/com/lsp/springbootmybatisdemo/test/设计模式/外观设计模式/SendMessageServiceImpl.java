package com.lsp.springbootmybatisdemo.test.设计模式.外观设计模式;

import lombok.extern.slf4j.Slf4j;

/**
 * @FileName: SendMessageServiceImpl
 * @Description: 发送短信实现
 * @AuthOr: lsp
 * @Date: 2020/1/12 14:37
 */
@Slf4j
public class SendMessageServiceImpl implements SendMessageService {
    @Override
    public void send() {
        log.info("发送短信");
    }
}

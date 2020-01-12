package com.lsp.springbootmybatisdemo.test.设计模式.外观设计模式;

import lombok.extern.slf4j.Slf4j;

/**
 * @FileName: EmailSendMessageServiceImpl
 * @Description:
 * @AuthOr: lsp
 * @Date: 2020/1/12 14:43
 */
@Slf4j
public class EmailSendMessageServiceImpl implements EmailSendMessageService {
    @Override
    public void EmailSendMessage() {
        log.info("邮件发送消息---");
    }
}

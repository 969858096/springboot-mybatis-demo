package com.lsp.springbootmybatisdemo.test.设计模式.外观设计模式;

import lombok.extern.slf4j.Slf4j;

/**
 * @FileName: WeixinSendMessageServiceImpl
 * @Description:
 * @AuthOr: lsp
 * @Date: 2020/1/12 14:41
 */
@Slf4j
public class WeixinSendMessageServiceImpl implements WeixinSendMessageService {

    @Override
    public void WeiXinSendMessage() {
        log.info("微信消息发送---");
    }
}

package com.lsp.springbootmybatisdemo.test.设计模式.模板方法模式;

import lombok.extern.slf4j.Slf4j;

/**
 * @FileName: MsgTemplate
 * @Description:
 * @AuthOr: lsp
 * @Date: 2020/1/11 23:24
 */
@Slf4j
public abstract class MsgTemplate {
    public void sendMsg() {
        beginLog();//开始日志
        httpRequest();//发送请求
        endLog();//结束日志
    }

    private void beginLog() {
        log.info("开始日志");
    }

    public abstract void httpRequest();//定义为抽象方法 供不同的自类去实现

    private void endLog() {
        log.info("结束日志");
    }

}

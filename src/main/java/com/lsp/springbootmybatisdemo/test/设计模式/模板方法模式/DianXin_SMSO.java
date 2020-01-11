package com.lsp.springbootmybatisdemo.test.设计模式.模板方法模式;

import lombok.extern.slf4j.Slf4j;

/**
 * @FileName: DianXin_SMSO
 * @Description: 电信短息运营
 * @AuthOr: lsp
 * @Date: 2020/1/11 23:36
 */
@Slf4j
public class DianXin_SMSO extends MsgTemplate {
    @Override
    public void httpRequest() {
        log.info("dianXin URL---");
    }
}

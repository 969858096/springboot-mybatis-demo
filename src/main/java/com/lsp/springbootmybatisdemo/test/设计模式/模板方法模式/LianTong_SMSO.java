package com.lsp.springbootmybatisdemo.test.设计模式.模板方法模式;

import lombok.extern.slf4j.Slf4j;

/**
 * @FileName: LianTong_SMSO
 * @Description: 联通短息运营
 * @AuthOr: lsp
 * @Date: 2020/1/11 23:35
 */
@Slf4j
public class LianTong_SMSO extends MsgTemplate {
    @Override
    public void httpRequest() {
        log.info("lianTong URL---");
    }
}

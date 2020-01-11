package com.lsp.springbootmybatisdemo.test.设计模式.模板方法模式;

import lombok.extern.slf4j.Slf4j;

/**
 * @FileName: YiDong_SMSO
 * @Description: 移动短息运营
 * @AuthOr: lsp
 * @Date: 2020/1/11 23:34
 */
@Slf4j
public class YiDong_SMSO extends MsgTemplate {
    @Override
    public void httpRequest() {
        log.info("yiDong URL----");
    }
}

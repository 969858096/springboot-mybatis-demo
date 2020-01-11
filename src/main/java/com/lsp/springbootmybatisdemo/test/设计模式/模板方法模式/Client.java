package com.lsp.springbootmybatisdemo.test.设计模式.模板方法模式;

/**
 * @FileName: Client
 * @Description:
 * @AuthOr: lsp
 * @Date: 2020/1/11 23:39
 */
public class Client {
    public static void main(String[] args) {
        //使用移动短信服务
        MsgTemplate yiDong = new YiDong_SMSO();
        yiDong.sendMsg();

        //使用联通短信服务
        MsgTemplate lianTong = new LianTong_SMSO();
        lianTong.sendMsg();

        //使用电信短信服务
        MsgTemplate dianXin = new DianXin_SMSO();
        dianXin.sendMsg();
    }
}

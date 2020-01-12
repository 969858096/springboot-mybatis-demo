package com.lsp.springbootmybatisdemo.test.设计模式.外观设计模式;

/**
 * @FileName: Appearance
 * @Description: 创建门面  封装接口
 * @AuthOr: lsp
 * @Date: 2020/1/12 14:47
 */
public class Appearance {
    private EmailSendMessageService emailSendMessageService;
    private WeixinSendMessageService weixinSendMessageService;
    private SendMessageService sendMessageService;

    public Appearance() {//利用无参构造方法，初始化赋值
        emailSendMessageService = new EmailSendMessageServiceImpl();
        weixinSendMessageService = new WeixinSendMessageServiceImpl();
        sendMessageService = new SendMessageServiceImpl();
    }

    public void sendMessage(){
        emailSendMessageService.EmailSendMessage();
        weixinSendMessageService.WeiXinSendMessage();
        sendMessageService.send();
    }
}

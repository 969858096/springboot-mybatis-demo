package com.lsp.springbootmybatisdemo.acrtivemq.消息发布订阅;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;


/**
 * @program: springboot-mybatis-demo
 * @description: 订阅话题
 * @author: lsp
 * @create: 2020-01-09 15:25
 * @version:1.0
 **/
@Component
public class Subscriber {

    @JmsListener(destination = "topic.test",containerFactory = "myJmsContainerFactory")
    public void subscribe(String message){
        System.out.println("《topic.test1》==========接收信息----》"+message);
    }

    @JmsListener(destination = "topic.test",containerFactory = "myJmsContainerFactory")
    public void receive1(String message) {
        System.out.println("《topic.test2》==========接收信息----》"+message);
    }

    @JmsListener(destination = "topic.test",containerFactory = "myJmsContainerFactory")
    public void receive2(String message) {
        System.out.println("《topic.test3》==========接收信息----》"+message);
    }
}

package com.lsp.springbootmybatisdemo.acrtivemq.消息发布订阅;

import com.alibaba.fastjson.JSONObject;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


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
    public void subscribe(String text){
        System.out.println("==========收到订阅信息"+text);
    }

    @JmsListener(destination = "topic.test",containerFactory = "myJmsContainerFactory")
    public void receive1(String message) {
        System.err.println("Topic.Subscribe.receive1接收消息：" + message);
    }


}

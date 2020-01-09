package com.lsp.springbootmybatisdemo.acrtivemq;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

/**
 * @program: springboot-mybatis-demo
 * @description: 消息消费者
 * @author: lsp
 * @create: 2020-01-09 14:17
 * @version:1.0
 **/
@Service
public class MessageConsumer {

    @JmsListener(destination = "name.msg")
    public void receive(String message){
        System.out.println("<<<<<接收消息---"+message);
    }

    @JmsListener(destination = "test.msg")
    public void receive1(String message){
        JSONObject json = JSON.parseObject(message);
        System.out.println("<<<<<接收消息---"+json.getString("msg"));
    }
}

package com.lsp.springbootmybatisdemo.acrtivemq.消息发布订阅;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.config.SimpleJmsListenerContainerFactory;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;

/**
 * @program: springboot-mybatis-demo
 * @description: 发布话题
 * @author: lsp
 * @create: 2020-01-09 15:21
 * @version:1.0
 **/
@Service
public class Publisher {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    public void publish(String destinationName,String message){
        ActiveMQTopic destination = new ActiveMQTopic(destinationName);//创建发送地点对象
        System.out.println("发送topic信息--"+message);
        jmsMessagingTemplate.convertAndSend(destination,message);
    }
}

package com.lsp.springbootmybatisdemo.acrtivemq.点对点模式;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Component;
import javax.jms.Destination;

/**
 * @program: springboot-mybatis-demo
 * @description: 消息生产者
 * @author: lsp
 * @create: 2020-01-09 13:56
 * @version:1.0
 **/
@Component
public class MessageProducer {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
    //发送消息
    public boolean sendMessage(final String message,String destinationName){
        try {
            System.out.println(">>>>>>>>发送消息--"+message);
            Destination destination = new ActiveMQQueue(destinationName);//创建发送地点对象
            jmsMessagingTemplate.convertAndSend(destinationName,message);//发送消息
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}

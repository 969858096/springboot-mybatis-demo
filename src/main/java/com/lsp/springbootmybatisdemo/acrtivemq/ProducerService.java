package com.lsp.springbootmybatisdemo.acrtivemq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: springboot-mybatis-demo
 * @description: 模拟消息生产者
 * @author: lsp
 * @create: 2020-01-09 14:22
 * @version:1.0
 **/
@Service
public class ProducerService {
    @Autowired
    private MessageProducer messageProducer;

    public Object send(String message,String destinationName){
        return messageProducer.sendMessage(message,destinationName);
    }
}

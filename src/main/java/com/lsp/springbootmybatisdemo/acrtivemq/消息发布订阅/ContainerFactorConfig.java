package com.lsp.springbootmybatisdemo.acrtivemq.消息发布订阅;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.config.SimpleJmsListenerContainerFactory;
import org.springframework.stereotype.Component;

import javax.jms.ConnectionFactory;

/**
 * @program: springboot-mybatis-demo
 * @description: 容器工厂配置
 * @author: lsp
 * @create: 2020-01-09 15:32
 * @version:1.0
 **/
@Configuration
@Component
public class ContainerFactorConfig {

    @Bean
    JmsListenerContainerFactory<?> myJmsContainerFactory(ConnectionFactory connectionFactory){
        SimpleJmsListenerContainerFactory factory = new SimpleJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setPubSubDomain(true);
        return factory;
    }

}

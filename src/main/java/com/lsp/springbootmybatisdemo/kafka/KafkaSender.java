package com.lsp.springbootmybatisdemo.kafka;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

/**
 * @program: springboot-mybatis-demo
 * @description: 消息发送
 * @author: lsp
 * @create: 2020-01-10 18:20
 * @version:1.0
 **/
@Component
@Slf4j
public class KafkaSender {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;


    public void send(){
        Message message = new Message();
        message.setId(System.currentTimeMillis());
        message.setMsg(UUID.randomUUID().toString());
        message.setSendTime(new Date());
        JSONObject jsonObject = (JSONObject) JSON.toJSON(message);
        log.info("发送消息="+jsonObject);
        kafkaTemplate.send("lsp",jsonObject.toString());
    }
}

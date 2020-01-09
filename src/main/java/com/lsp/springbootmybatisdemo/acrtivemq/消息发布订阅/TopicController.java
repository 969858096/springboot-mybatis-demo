package com.lsp.springbootmybatisdemo.acrtivemq.消息发布订阅;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: springboot-mybatis-demo
 * @description:
 * @author: lsp
 * @create: 2020-01-09 16:41
 * @version:1.0
 **/
@Controller
@RequestMapping("mq")
public class TopicController {

    @Autowired
    private Publisher publish;

    @RequestMapping("test")
    public void Test(){
        publish.publish("topic.test","发送消息+++++++++++++++++++++");
    }
}

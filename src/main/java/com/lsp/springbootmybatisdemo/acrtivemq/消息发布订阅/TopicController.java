package com.lsp.springbootmybatisdemo.acrtivemq.消息发布订阅;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    @ResponseBody
    public void Test(){
        publish.publish("topic.test","伊美大战即将开始，敬请关注！！");
    }
}

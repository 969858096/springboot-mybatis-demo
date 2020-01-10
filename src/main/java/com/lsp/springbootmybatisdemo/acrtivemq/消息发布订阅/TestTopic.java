package com.lsp.springbootmybatisdemo.acrtivemq.消息发布订阅;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @program: springboot-mybatis-demo
 * @description:
 * @author: lsp
 * @create: 2020-01-09 15:34
 * @version:1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@EnableJms
public class TestTopic {
    @Autowired
    private Publisher publish;

    @Test
    public void test() {
        publish.publish("topic.test", "Topic Message " + "发送的信息");
    }
}

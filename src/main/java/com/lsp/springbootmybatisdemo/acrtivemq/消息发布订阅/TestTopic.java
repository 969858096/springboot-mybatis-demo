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
        JSONObject json = new JSONObject();
        System.out.println(publish);
        for (int i = 0; i < 10; i++) {
            publish.publish("topic.test", "Topic Message " + json.put("msg","发布信息"+i).toString());
        }
    }
}

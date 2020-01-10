package com.lsp.springbootmybatisdemo.acrtivemq.点对点模式;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @program: springboot-mybatis-demo
 * @description: 测试消息发送接收
 * @author: lsp
 * @create: 2020-01-09 14:24
 * @version:1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestActiveMq {
    @Resource
    private ProducerService producerService;


    @Test
    public void contextLoads() {
        JSONObject json = new JSONObject();
        int i = 0;
        while (i < 150) {
            try {
                Thread.sleep(2000);
                producerService.send("message->" + i, "name.msg");
                json.put("msg", "测试发送信息" + i);
                producerService.send(json.toString(), "test.msg");
                i++;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

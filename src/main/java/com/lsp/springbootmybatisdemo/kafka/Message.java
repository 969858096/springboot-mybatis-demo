package com.lsp.springbootmybatisdemo.kafka;

import lombok.Data;

import java.util.Date;

/**
 * @program: springboot-mybatis-demo
 * @description: 消息实体类
 * @author: lsp
 * @create: 2020-01-10 18:17
 * @version:1.0
 **/
@Data
public class Message {
    private Long id;
    private String msg;
    private Date sendTime;
}

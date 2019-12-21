package com.lsp.springbootmybatisdemo.test;

import com.lsp.springbootmybatisdemo.entity.User;
import com.lsp.springbootmybatisdemo.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @program: springboot-mybatis-demo
 * @description:
 * @author: lsp
 * @create: 2019-12-11 16:45
 * @version:1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;


    /*@Test
    public void deleteById() {
        int result = userMapper.deleteById("");
        String a = result == 1 ? "删除成功" : "删除失败";
        System.out.println(a);
    }*/


}

package com.lsp.springbootmybatisdemo;

import com.lsp.springbootmybatisdemo.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringbootMybatisDemoApplicationTests {

    @Autowired
    private UserMapper userMapper;

   /* @Test
    List contextLoads() {
       return userMapper.getAll();
    }*/

}

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

    @Test
    public void showAll() {
        List<User> userList = userMapper.getAll();
        for (User user : userList) {
            System.out.println(user.getName());
        }
    }

    @Test
    public void deleteById() {
        int result = userMapper.delete("1");
        String a = result == 1 ? "删除成功" : "删除失败";
        System.out.println(a);
    }

    @Test
    public void deleteAll() {
        List<User> userList = userMapper.getAll();
        for (User user : userList) {
            userMapper.delete(user.getId());
        }
    }

    @Test
    public void add() {
        User user = null;
        for (int i = 0; i < 10; i++) {
            user = new User("李四"+i,10+i,"管理员"+i,"lsp"+i);
            userMapper.insert(user);
        }
    }


    @Test
    public void update() {
        User user = userMapper.getOne("fc3f03701c8911eabbcf00ff77eaefef");
        user.setAge(100);
        user.setName("李世民");
        userMapper.update(user);
    }


}

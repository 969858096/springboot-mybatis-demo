package com.lsp.springbootmybatisdemo.test;

import com.lsp.springbootmybatisdemo.entity.Student;
import com.lsp.springbootmybatisdemo.impl.StudentImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: springboot-mybatis-demo
 * @description:
 * @author: lsp
 * @create: 2019-12-20 09:30
 * @version:1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class jdbcTemplateTest {

    @Resource
    private StudentImpl studentImpl;

    @Test
    public void testAdd(){
        Student student = null;
        for (int i = 0; i < 10; i++) {
            String id = "00"+i;
            student = new Student(id,"李小龙",51);
            studentImpl.jdbcTemplate_Save(student);
        }

    }

    @Test
    public void testDelete() {
        studentImpl.jdbcTemplate_delete("000");
    }

    @Test
    public void testQueryAll(){
       List<Student> list = studentImpl.jdbcTemplate_QueryAll();
        for (Student student : list) {
            System.out.println(student);
        }
    }
}

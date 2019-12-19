package com.lsp.springbootmybatisdemo.impl;

import com.lsp.springbootmybatisdemo.entity.Student;
import com.lsp.springbootmybatisdemo.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program: springboot-mybatis-demo
 * @description: 学生实现类
 * @author: lsp
 * @create: 2019-12-19 16:40
 * @version:1.0
 **/
@Service
@Transactional(rollbackFor = Exception.class)
public class StudentImpl implements StudentMapper {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Student findById(String id) {
        return studentMapper.findById(id);
    }

    @Override
    public Student findByName(String name) {
        return studentMapper.findByName(name);
    }

    @Override
    public int deleteById(String id) {
        return studentMapper.deleteById(id);
    }

    @Override
    public List<Student> getAll() {
        return studentMapper.getAll();
    }

    @Override
    public int add(Student student) {
        return studentMapper.add(student);
    }

    @Override
    public int update(Student student) {
        return studentMapper.update(student);
    }

    @Override
    public int bulkInsert(List<Student> list) {
        return studentMapper.bulkInsert(list);
    }
}

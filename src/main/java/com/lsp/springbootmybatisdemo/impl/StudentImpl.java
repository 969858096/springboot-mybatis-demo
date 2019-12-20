package com.lsp.springbootmybatisdemo.impl;

import com.lsp.springbootmybatisdemo.entity.Student;
import com.lsp.springbootmybatisdemo.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
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
    @Autowired
    private JdbcTemplate jdbcTemplate;

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

    public int jdbcTemplate_Save(Student student){
        return jdbcTemplate.update("INSERT INTO STUDENT (id,name,age) VALUES(?,?,?)",student.getId(),student.getName(),student.getAge());
    }

    public int jdbcTemplate_delete(String id){
        return jdbcTemplate.update("delete from student where id = ?",id);
    }

    public List<Student> jdbcTemplate_QueryAll(){
        return jdbcTemplate.query("select * from student",new BeanPropertyRowMapper(Student.class));
    }
}

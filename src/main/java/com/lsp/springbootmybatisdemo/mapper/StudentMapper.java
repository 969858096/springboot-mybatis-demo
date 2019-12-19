package com.lsp.springbootmybatisdemo.mapper;

import com.lsp.springbootmybatisdemo.entity.Student;
import com.lsp.springbootmybatisdemo.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StudentMapper {

    @Select("SELECT * FROM STUDENT WHERE id = #{id}")
    Student findById(@Param("id") String id);

    @Select("SELECT * FROM STUDENT WHERE name = #{name}")
    Student findByName(@Param("name") String name);

    @Delete("DELETE FROM STUDENT WHERE ID = #{ID}")
    int deleteById(@Param("id") String id);


    List<Student> getAll();
    int add(Student student);
    int update(Student student);
    int bulkInsert(@Param("list") List<Student> list);

}

package com.lsp.springbootmybatisdemo.mapper;

import com.lsp.springbootmybatisdemo.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    /*@Select("SELECT * FROM USER WHERE name = #{name}")
    User findUserByName(@Param("name") String name);

    @Insert("INSERT INTO USER（NAME,AGE）VALUES(#{name}, #{age})")
    int insert(@Param("name") String name, @Param("age") Integer age);

    @Update("UPDATE USER SET NAME = #{name} WHERE ID=#{id}")
    int update(@Param("name") String name,@Param("id") String id);*/


    List<User> getAll();
    User getOne(String id);
    int insert(User user);
    int update(User user);
    int delete(String id);

}

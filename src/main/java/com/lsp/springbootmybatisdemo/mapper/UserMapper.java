package com.lsp.springbootmybatisdemo.mapper;

import com.lsp.springbootmybatisdemo.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM USER WHERE id = #{id}")
    User findById(@Param("id") String id);

    @Select("SELECT * FROM USER WHERE name = #{name}")
    User findByName(@Param("name") String name);

    @Delete("DELETE FROM USER WHERE ID = #{ID}")
    int deleteById(@Param("id") String id);


    List<User> getAll();
    int add(User user);
    int update(User user);

}

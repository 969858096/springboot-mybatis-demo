package com.lsp.springbootmybatisdemo.mapper;

import com.lsp.springbootmybatisdemo.entity.Permission;
import com.lsp.springbootmybatisdemo.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


import java.util.List;

public interface UserMapper {
    // 查询用户信息
    @Select(" select * from sys_user where username = #{userName}")
    User findByUsername(@Param("userName") String userName);

    // 查询用户的权限
    @Select(" select permission.* from sys_user user" + " inner join sys_user_role user_role"
            + " on user.id = user_role.user_id inner join "
            + "sys_role_permission role_permission on user_role.role_id = role_permission.role_id "
            + " inner join sys_permission permission on role_permission.perm_id = permission.id where user.username = #{userName};")
    List<Permission> findPermissionByUsername(@Param("userName") String userName);

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

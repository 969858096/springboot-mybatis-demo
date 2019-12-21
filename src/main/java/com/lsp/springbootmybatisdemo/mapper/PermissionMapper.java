package com.lsp.springbootmybatisdemo.mapper;

import java.util.List;

import com.lsp.springbootmybatisdemo.entity.Permission;
import org.apache.ibatis.annotations.Select;


public interface PermissionMapper {

    @Select(" select * from sys_permission ")
    List<Permission> findAllPermission();

}

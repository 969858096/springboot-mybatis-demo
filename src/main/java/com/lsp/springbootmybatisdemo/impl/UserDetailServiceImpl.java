package com.lsp.springbootmybatisdemo.impl;

import com.lsp.springbootmybatisdemo.entity.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: springboot-mybatis-demo
 * @description:
 * @author: lsp
 * @create: 2019-12-20 11:03
 * @version:1.0
 **/
public class UserDetailServiceImpl implements UserDetailsService {

    @Resource
    private UserImpl userRoleMapper ;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 这里可以捕获异常，使用异常映射，抛出指定的提示信息
        // 用户校验的操作
        // 假设密码是数据库查询的 123
         String password = "$2a$10$XcigeMfToGQ2bqRToFtUi.sG1V.HhrJV6RBjji1yncXReSNNIPl1K";
        // 假设角色是数据库查询的
         com.lsp.springbootmybatisdemo.entity.User user = userRoleMapper.findByName(username);
         List<Role> roleList = userRoleMapper.selectAllRoles(user.getId());

         List<String> roles = new ArrayList<>();
        for (Role role : roleList) {
            roles.add(role.getName());
        }
         List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
        /*
         * Spring Boot 2.0 版本踩坑
         * 必须要 ROLE_ 前缀， 因为 hasRole("LEVEL1")判断时会自动加上ROLE_前缀变成 ROLE_LEVEL1 ,
         * 如果不加前缀一般就会出现403错误
         * 在给用户赋权限时,数据库存储必须是完整的权限标识ROLE_LEVEL1
         */
        if (roles != null && roles.size() > 0){
            for (String role : roles) {
                grantedAuthorityList.add(new SimpleGrantedAuthority(role));
            }
        }
        return new User(username,password,grantedAuthorityList);
    }
}

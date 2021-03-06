package com.lsp.springbootmybatisdemo.impl;

import com.lsp.springbootmybatisdemo.entity.Permission;
import com.lsp.springbootmybatisdemo.entity.Role;
import com.lsp.springbootmybatisdemo.entity.User;
import com.lsp.springbootmybatisdemo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program: springboot-mybatis-demo
 * @description: 用户实现类
 * @author: lsp
 * @create: 2019-12-19 16:47
 * @version:1.0
 **/
@Service
@Transactional(rollbackFor = Exception.class)
public class UserImpl implements UserMapper {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByUsername(String userName) {
        return userMapper.findByUsername(userName);
    }

    @Override
    public List<Permission> findPermissionByUsername(String userName) {
        return userMapper.findPermissionByUsername(userName);
    }

    @Override
    public User findById(String id) {
        return userMapper.findById(id);
    }

    @Override
    public User findByName(String name) {
        return userMapper.findByName(name);
    }

    @Override
    public int deleteById(String id) {
        return 0;
    }

    @Override
    public List<User> getAll() {
        return userMapper.getAll();
    }

    @Override
    public int add(User user) {
        return userMapper.add(user);
    }

    @Override
    public int update(User user) {
        return userMapper.update(user);
    }
}

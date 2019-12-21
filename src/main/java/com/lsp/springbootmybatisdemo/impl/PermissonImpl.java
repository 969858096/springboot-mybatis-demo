package com.lsp.springbootmybatisdemo.impl;

import com.lsp.springbootmybatisdemo.entity.Permission;
import com.lsp.springbootmybatisdemo.mapper.PermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @FileName: PermissonImpl
 * @Description:
 * @AuthOr: lsp
 * @Date: 2019/12/21 17:57
 */
@Service
public class PermissonImpl implements PermissionMapper {
    @Autowired PermissionMapper permissionMapper;

    @Override
    public List<Permission> findAllPermission() {
        return permissionMapper.findAllPermission();
    }
}

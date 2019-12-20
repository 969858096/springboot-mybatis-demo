package com.lsp.springbootmybatisdemo.entity;

import java.util.List;

/**
 * @program: springboot-mybatis-demo
 * @description: 角色表
 * @author: lsp
 * @create: 2019-12-20 11:22
 * @version:1.0
 **/
public class Role {

    private String id;
    private String name;
    private List<Authority> authorityList;

    public List<Authority> getAuthorityList() {
        return authorityList;
    }

    public void setAuthorityList(List<Authority> authorityList) {
        this.authorityList = authorityList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

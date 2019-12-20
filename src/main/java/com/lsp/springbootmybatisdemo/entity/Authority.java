package com.lsp.springbootmybatisdemo.entity;

/**
 * @program: springboot-mybatis-demo
 * @description: 权限表
 * @author: lsp
 * @create: 2019-12-20 11:26
 * @version:1.0
 **/
public class Authority {
    private String id;
    private String name;
    private String url;

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Authority{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}

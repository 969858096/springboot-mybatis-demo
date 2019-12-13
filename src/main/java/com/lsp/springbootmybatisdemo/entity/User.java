package com.lsp.springbootmybatisdemo.entity;

import java.io.Serializable;

/**
 * @program: springboot-mybatis-demo
 * @description:
 * @author: lsp
 * @create: 2019-12-11 16:34
 * @version:1.0
 **/
public class User implements Serializable {

    private String id;
    private String name;
    private Integer age;
    private String userName;
    private String passWord;
    private Integer phoneNum;

    public User() {
    }

    public User(String id, String name, Integer age, String userName, String passWord,Integer phoneNum) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.userName = userName;
        this.passWord = passWord;
        this.phoneNum = phoneNum;
    }

    public Integer getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(Integer phoneNum) {
        this.phoneNum = phoneNum;
    }

    public User(String name, Integer age, String userName, String passWord, Integer phoneNum) {
        this.name = name;
        this.age = age;
        this.userName = userName;
        this.passWord = passWord;
        this.phoneNum = phoneNum;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", phoneNum=" + phoneNum +
                '}';
    }
}

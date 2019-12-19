package com.lsp.springbootmybatisdemo.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: springboot-mybatis-demo
 * @description:
 * @author: lsp
 * @create: 2019-12-11 16:34
 * @version:1.0
 **/
@Data
@Builder
public class User extends BaseRowModel implements Serializable {

    @ExcelProperty(value = {"个人信息","编号"}, index = 0)
    private String id;
    @ExcelProperty(value =  {"个人信息","姓名"}, index = 1)
    private String name;
    @ExcelProperty(value =  {"个人信息","年龄"}, index = 2)
    private Integer age;
    @ExcelProperty(value = {"账户信息","账号"}, index = 3)
    private String userName;
    @ExcelProperty(value = {"账户信息","密码"}, index = 4)
    private String passWord;
    @ExcelProperty(value = {"手机号"}, index = 5)
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

package com.lsp.springbootmybatisdemo.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

import java.io.Serializable;

/**
 * @FileName: Student
 * @Description:
 * @AuthOr: lsp
 * @Date: 2019/12/19 00:36
 */
public class Student extends BaseRowModel implements Serializable {

    @ExcelProperty(value = {"编号"}, index = 0)
    private String id;
    @ExcelProperty(value = {"姓名"}, index = 1)
    private String name;
    @ExcelProperty(value = {"年龄"}, index = 2)
    private Integer age;

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


}

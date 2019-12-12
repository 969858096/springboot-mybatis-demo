package com.lsp.springbootmybatisdemo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.lsp.springbootmybatisdemo.entity.User;
import com.lsp.springbootmybatisdemo.mapper.UserMapper;
import com.lsp.springbootmybatisdemo.utils.ReflectUtils;
import com.mysql.cj.result.Row;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

/**
 * @program: springboot-mybatis-demo
 * @description:
 * @author: lsp
 * @create: 2019-12-12 10:54
 * @version:1.0
 **/
@Controller
@RequestMapping(value = "user")
public class UserController {

    @Resource
    private UserMapper userMapper;


    @RequestMapping(value = "list")
    @ResponseBody
    public List list(){
        return userMapper.getAll();
    }

    @RequestMapping(value = "runInto")
    public String  runInto(Model model){
        User user = userMapper.getOne("c44af1a71cdf11eab17600d8616f83b2");
       model.addAttribute("user",user);
        return "index";
    }

    @RequestMapping(value = "save")
    public String  save(@RequestParam  Map<String,Object> map) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        User user = (User) ReflectUtils.mapToJavaObject( User.class,map);
        userMapper.update(user);
        return "success";
    }

    @RequestMapping("/export")
    public void export(@RequestParam("excelFile") MultipartFile file, HttpServletRequest request, HttpServletResponse response) {

    }


}

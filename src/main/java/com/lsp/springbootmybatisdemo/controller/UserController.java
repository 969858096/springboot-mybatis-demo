package com.lsp.springbootmybatisdemo.controller;

import com.lsp.springbootmybatisdemo.entity.User;
import com.lsp.springbootmybatisdemo.mapper.UserMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import javax.annotation.Resource;
import java.util.List;

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
        User user = userMapper.getOne("32f0fa091cc211eabdb300ff77eaefef");
       /* model.addAttribute("id",user.getId());
        model.addAttribute("name",user.getName());
        model.addAttribute("age",user.getAge());
       model.addAttribute("userName","你好世界");
       model.addAttribute("passWord","123456");*/
       model.addAttribute("user",user);
        return "index";
    }

    @RequestMapping(value = "save")
    public String  save(Model model, @Param("id")String id){
       User user = (User) model.getAttribute("user");
       userMapper.insert(user);
        return "保存成功";
    }

}

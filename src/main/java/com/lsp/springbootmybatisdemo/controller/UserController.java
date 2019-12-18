/*
package com.lsp.springbootmybatisdemo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lsp.springbootmybatisdemo.entity.User;
import com.lsp.springbootmybatisdemo.mapper.UserMapper;
import com.lsp.springbootmybatisdemo.utils.ReflectUtils;
import com.lsp.springbootmybatisdemo.utils.
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

*/
/**
 * @program: springboot-mybatis-demo
 * @description:
 * @author: lsp
 * @create: 2019-12-12 10:54
 * @version:1.0
 **//*

@Controller
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping(value = "list")
    @ResponseBody
    public List list() {
        return userMapper.getAll();
    }

    @RequestMapping(value = "runInto")
    public String runInto(Model model, @Param(value = "id") String id) {
        User user = userMapper.findById(id);
        model.addAttribute("user", user);
        return "index";
    }

    @RequestMapping(value = "save")
    public String save(@RequestParam Map<String, Object> map) throws Exception {
        User user = (User) ReflectUtils.mapToJavaObject(User.class, map);
        int flag;
        if (map.containsKey("id") && map.get("id").equals("")) {
            flag = userMapper.add(user);
        } else {
            flag = userMapper.update(user);
        }
        return flag == 1 ? "success" : "failure";
    }

    @RequestMapping(value = "save1")
    public String save1(@RequestBody String user) throws Exception {
        JSONObject jsonObject = JSONObject.parseObject(user);
        User user1 = JSON.toJavaObject(jsonObject,User.class);
        if (user != null) {
            userMapper.add(user1);
            return "success";
        }
        return "failure";
    }


    @RequestMapping("/export")
    public void export(@RequestBody MultipartFile file, HttpServletRequest request, HttpServletResponse response) {
        String filePath = "/home/chenmingjian/Downloads/测试.xlsx";
        List<Object> objects = com.springboot.utils.excel.ExcelUtil.readLessThan1000Row(filePath);
        objects.forEach(System.out::println);

    }

    @RequestMapping("/excel")
    public String excel() {
        return "excel";
    }


}
*/

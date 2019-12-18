package com.lsp.springbootmybatisdemo.controller;

import com.lsp.springbootmybatisdemo.mapper.StudentMapper;
import com.lsp.springbootmybatisdemo.utils.ExtelRead;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @FileName: StudentController
 * @Description:
 * @AuthOr: lsp
 * @Date: 2019/12/19 00:44
 */
@Controller
@RequestMapping(value = "/student/")
public class StudentController {

    @Autowired
    private StudentMapper studentMapper;

    @RequestMapping(value = "export")
    public List testExcelExport(){
        String file = "E:\\soft_project\\excel\\student.xlsx";
        List<List<String>> lists = ExtelRead.testRead(file);
        if(lists != null){
            System.out.println(lists.size());
        }else{
            System.out.println("异常");
        }
        return lists;
    }
}

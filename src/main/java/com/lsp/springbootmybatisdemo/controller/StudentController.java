package com.lsp.springbootmybatisdemo.controller;


import com.lsp.springbootmybatisdemo.entity.Student;
import com.lsp.springbootmybatisdemo.impl.StudentImpl;
import com.lsp.springbootmybatisdemo.impl.UserImpl;
import com.lsp.springbootmybatisdemo.utils.ExcelUtils;
import com.lsp.springbootmybatisdemo.utils.ReflectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import java.util.ArrayList;
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
    private StudentImpl studentImpl;

    @Autowired
    private UserImpl userImpl;

    @RequestMapping(value = "chooseExcelFile")
    public String chooseExcelFile() {
        return "excel";
    }

    @RequestMapping(value = "import")
    public String testExcelExport(@RequestParam(value = "file") MultipartFile file) throws Exception {
        List<List<Object>> lists = ExcelUtils.ReadExcelIntoDB(file);
        for (List<Object> list : lists) {
            Object object = ReflectUtils.listToJavaObject(Student.class, list);
            if (object instanceof Student){
                Student student1 = (Student)object;
                studentImpl.add(student1);
            }else {
                throw new ClassCastException("类转换异常");
            }
        }
        return "success";
    }

    //相对高效的批量插入
    @RequestMapping(value = "import1")
    public String testExcelExport1(@RequestParam(value = "file") MultipartFile file) throws Exception {
        List<List<Object>> lists = ExcelUtils.ReadExcelIntoDB(file);
        List<Student> listStudent = new ArrayList<>();
        for (List<Object> list : lists) {
            Student student = (Student) ReflectUtils.listToJavaObject(Student.class, list);
            listStudent.add(student);
        }
        studentImpl.bulkInsert(listStudent);
        return "success";
    }

   /* //导出一个工作簿
    @RequestMapping(value = "export")
    public String exportExcelTest() {
        String path = "E:\\soft_project\\excel\\test1.xlsx";
        ExcelUtils.writeDBToExcel(userImpl.getAll(),path);
        return "success";
    }*/
}

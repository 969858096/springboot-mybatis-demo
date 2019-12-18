package com.lsp.springbootmybatisdemo.test;

import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.metadata.Table;
import com.alibaba.excel.read.context.AnalysisContext;
import com.alibaba.excel.read.event.AnalysisEventListener;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.lsp.springbootmybatisdemo.entity.User;
import com.lsp.springbootmybatisdemo.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: springboot-mybatis-demo
 * @description:
 * @author: lsp
 * @create: 2019-12-17 13:44
 * @version:1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class ExcelWriteTest {

    @Autowired
    private UserMapper userMapper;

    @Test//没表头
    public void writeWithoutHead() throws IOException {
        try (OutputStream out = new FileOutputStream("withoutHead.xlsx");) {
            ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX, false);
            Sheet sheet1 = new Sheet(1, 0);
            sheet1.setSheetName("sheet1");
            List<List<String>> data = new ArrayList<>();//工作蒲的总行数
            for (int i = 0; i < 100; i++) {
                List<String> user = new ArrayList<>();//没行的单元格数
                user.add("user0" + i);
                user.add("user1" + i);
                user.add("user2" + i);
                data.add(user);
            }
            ExcelWriter excel = writer.write0(data, sheet1);
            writer.finish();
        }
    }

    @Test//带表头
    public void writeHead() throws IOException {
        try (OutputStream out = new FileOutputStream("withHead.xlsx");) {
            ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX);
            Sheet sheet1 = new Sheet(1, 0);
            sheet1.setSheetName("sheet1");
            List<List<String>> data = new ArrayList<>();
            for (int i = 0; i < 100; i++) {
                List<String> user = new ArrayList<>();
                user.add("user0" + i);
                user.add("user1" + i);
                user.add("user2" + i);
                data.add(user);
            }
            List<List<String>> head = new ArrayList<List<String>>();
            List<String> headCoulumn1 = new ArrayList<String>();
            List<String> headCoulumn2 = new ArrayList<String>();
            List<String> headCoulumn3 = new ArrayList<String>();
            headCoulumn1.add("第一列");
            headCoulumn2.add("第二列");
            headCoulumn3.add("第三列");
            head.add(headCoulumn1);
            head.add(headCoulumn2);
            head.add(headCoulumn3);
            Table table = new Table(1);
            table.setHead(head);
            writer.write0(data, sheet1, table);
            writer.finish();
        }
    }

    @Test//单行表头插入实体类（User extends BaseRowModel ）
    public void writeWithUser() throws IOException {
        try (OutputStream out = new FileOutputStream("user.xlsx");) {
            ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX);
            Sheet sheet1 = new Sheet(1, 0, User.class);
            sheet1.setSheetName("sheet1");
            List<User> data = userMapper.getAll();
            writer.write(data, sheet1);
            writer.finish();
        }
    }

    @Test
    public void intWithUser() throws IOException {
        try (OutputStream out = new FileOutputStream("withMultiHeadTest2.xlsx");) {
            ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX);
            Sheet sheet1 = new Sheet(1, 0, User.class);
            sheet1.setSheetName("sheet1");
            List<User> data = userMapper.getAll();
            writer.write(data, sheet1);
            writer.finish();
        }
    }

    @Test
    public void read() throws Exception {
        try (InputStream in = new FileInputStream("user.xlsx")) {
            AnalysisEventListener<User> listener = new AnalysisEventListener<User>() {

                @Override
                public void invoke(User object, AnalysisContext context) {
                    System.err.println("Row:" + context.getCurrentRowNum() + " Data:" + object);
                }

                @Override
                public void doAfterAllAnalysed(AnalysisContext context) {
                    System.err.println("doAfterAllAnalysed...");
                }
            };
            ExcelReader excelReader = ExcelReaderFactory.getExcelReader(in, null, listener);
            // 第二个参数为表头行数，按照实际设置
            excelReader.read(new Sheet(1, 1, User.class));
        }
    }

    @Test
    public void Test1() {
        System.setProperty("hello", "world");
        Object obj = System.getProperty("hello");
        System.out.println(obj);
    }
}




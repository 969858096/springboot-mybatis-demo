package com.lsp.springbootmybatisdemo.utils;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.BaseRowModel;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.lsp.springbootmybatisdemo.entity.User;
import org.junit.Test;
import org.springframework.web.multipart.MultipartFile;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtils {

    //excel数据导入到数据库
    public static List<List<Object>> ReadExcelIntoDB(MultipartFile file) throws IOException {
        if (file == null){
            throw new NullPointerException("file must not be null");
        }
        InputStream inputStream = file.getInputStream();
        try {
            String[] names = file.getOriginalFilename().split("\\.");
            String name = names[names.length-1];
            // 解析每行结果在listener中处理
            ExcelListener listener = new ExcelListener();
            ExcelReader excelReader = null;
            excelReader = name.equalsIgnoreCase("xlsx")?new ExcelReader(inputStream, ExcelTypeEnum.XLSX, null, listener):new ExcelReader(inputStream, ExcelTypeEnum.XLS, null, listener);
            excelReader.read();
            List<List<Object>> datas = listener.getDatas();
            datas.remove(0);  //把表头去掉，如果需要表头的话，可以把这句话删除掉
            return datas;
        } catch (Exception e) {
            e.printStackTrace();
            return  null;
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //从数据库导导出数据生成excel
    public static void writeDBToExcel(List list,String path){
        // 文件输出位置
        OutputStream out = null;
        try {
            out = new FileOutputStream(path);
            ExcelWriter writer = EasyExcelFactory.getWriter(out);
            Sheet sheet1 = new Sheet(1, 0, User.class);// 写仅有一个 Sheet 的 Excel 文件, 此场景较为通用
            sheet1.setSheetName("第一个sheet");// 第一个 sheet 名称
            // 写数据到 Writer 上下文中
            // 入参1: 数据库查询的数据list集合
            // 入参2: 要写入的目标 sheet
            writer.write(list, sheet1);
            writer.finish();// 将上下文中的最终 outputStream 写入到指定文件中
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                // 关闭流
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



}


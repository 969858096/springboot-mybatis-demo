package com.lsp.springbootmybatisdemo.utils;

import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.support.ExcelTypeEnum;


import java.io.*;
import java.util.List;

public class ExtelRead {

    private static InputStream getInputStream(String fileName) {
        try {
            return new FileInputStream(new File(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<List<String>> testRead(String fileName) {
        InputStream inputStream = getInputStream(fileName);
        try {
            // 解析每行结果在listener中处理
            ExcelListener listener = new ExcelListener();
            ExcelReader excelReader = new ExcelReader(inputStream, ExcelTypeEnum.XLSX, null, listener);
            excelReader.read();
            List<List<String>> datas = listener.getDatas();
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
}


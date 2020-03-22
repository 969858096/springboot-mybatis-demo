package com.lsp.springbootmybatisdemo.test.IO;

import java.io.*;

/**
 * @FileName: Demo
 * @Description:
 * @AuthOr: lsp
 * @Date: 2020/2/12 15:21
 */
public class Demo {
    public static void main(String[] args) throws Exception{
        test1();
    }

    public static void test1() throws IOException {
        File file = new File("G:\\JinXunClass\\70后端杨老师\\demo\\冰冰的故事\\第一章前十\\下半年","test1.txt");
        System.out.println(file.exists());
        file.mkdirs();
        InputStream fileInputStream = new FileInputStream(file);
        int len1 = fileInputStream.available();
        byte[] bytes = new byte[len1];
        fileInputStream.read(bytes);
        String str = new String(bytes);
        System.out.println(str);
        fileInputStream.close();

    }
}

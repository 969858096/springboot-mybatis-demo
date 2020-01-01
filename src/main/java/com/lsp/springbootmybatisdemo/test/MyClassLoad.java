package com.lsp.springbootmybatisdemo.test;

import java.io.*;

/**
 * @program: springboot-mybatis-demo
 * @description: 自定义类加载器
 * @author: lsp
 * @create: 2019-12-27 16:31
 * @version:1.0
 **/
public class MyClassLoad extends ClassLoader {
    private String path;

    public MyClassLoad(String path) {
        this.path = path;
    }

    @Override
    protected Class<?> findClass(String name){
        String classPath = path+name+".class";
        InputStream inputStream = null;
        ByteArrayOutputStream outputStream = null;
        try{
            inputStream = new FileInputStream(classPath);
            outputStream = new ByteArrayOutputStream();
            int temp  = 0;
            while ((inputStream.read()) != -1){
                outputStream.write(temp);
            }
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                outputStream.close();
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
         byte[] bytes = outputStream.toByteArray();
        return defineClass(name,bytes,0,bytes.length);
    }
}

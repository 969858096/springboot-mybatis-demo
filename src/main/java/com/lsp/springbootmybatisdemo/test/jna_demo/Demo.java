package com.lsp.springbootmybatisdemo.test.jna_demo;

import com.lsp.springbootmybatisdemo.utils.JnaUtil;
import com.sun.jna.Native;

/**
 * @program: springboot-mybatis-demo
 * @description:
 * @author: lsp
 * @create: 2019-12-24 17:42
 * @version:1.0
 **/
public class Demo {

    public static void main(String[] args) {


        //此刻dll文件扔在jdk的bin下
        CLibrary INSTANCE = (CLibrary) Native.loadLibrary("EQ6003_Dll.dll",CLibrary.class);
        JnaUtil.LED_INSTANCE = INSTANCE;
        //调用接口
        boolean i = INSTANCE.User_EQ6003_DelAllProgram(1);
        System.out.println(i);
    }
}

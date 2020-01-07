package com.lsp.springbootmybatisdemo.test;

import com.lsp.springbootmybatisdemo.test.jna_demo.CLibrary;
import com.sun.jna.Native;

/**
 * @program: springboot-mybatis-demo
 * @description:
 * @author: lsp
 * @create: 2019-12-24 17:42
 * @version:1.0
 **/
public class DemoDll {

    public static void main(String[] args) {
        CLibrary INSTANCE = (CLibrary) Native.loadLibrary ("D：\\EQ6003_Dll", CLibrary.class);
        System.out.println(INSTANCE);
    }
}

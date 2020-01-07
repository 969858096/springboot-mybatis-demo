package com.lsp.springbootmybatisdemo.test.jna_demo;
import com.sun.jna.Library;
import com.sun.jna.win32.StdCallLibrary;

public interface CLibrary extends StdCallLibrary {


    // 添加节目
    int User_EQ6003_AddProgram(int CardNum, boolean bWaitToEnd, int iPlayTime);

    // 删除所有节目
    boolean User_EQ6003_DelAllProgram(int CardNum);
}

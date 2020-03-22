package com.lsp.springbootmybatisdemo.test.huawei;

import java.util.Scanner;

/**
 * @FileName: demo2
 * @Description:
 * @AuthOr: lsp
 * @Date: 2020/3/19 15:51
 */
public class demo2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.next();
        char c = s.next().charAt(0);
        int i = test(str,c);
        System.out.println(i);
    }

    public static int test(String str,char c){
        char[] chars = str.toCharArray();
        int count = 0;
        if (str != null && str.length() >=0 ){
            for (int i = 0; i < chars.length; i++) {
                if (String.valueOf(chars[i]).equalsIgnoreCase(String.valueOf(c))){
                    count++;
                }
            }
        }
        return count;
    }
}

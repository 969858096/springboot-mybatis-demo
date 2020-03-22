package com.lsp.springbootmybatisdemo.test.huawei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @FileName: demo1
 * @Description:
 * @AuthOr: lsp
 * @Date: 2020/3/19 15:00
 */
public class demo1 {
    public static int lengthOfLast(String str) {
        String[] s =str.split(" ");
        return s[s.length-1].length();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            String str = scan.nextLine();
            System.out.println(lengthOfLast(str));
        }
    }
}

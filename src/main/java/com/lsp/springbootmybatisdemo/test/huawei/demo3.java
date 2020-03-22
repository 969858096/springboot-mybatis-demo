package com.lsp.springbootmybatisdemo.test.huawei;

import java.util.Scanner;

/**
 * @FileName: demo3
 * @Description:
 * @AuthOr: lsp
 * @Date: 2020/3/19 16:15
 */
public class demo3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入年份");
        int year = scanner.nextInt();
        System.out.println("请输入月份");
        int month = scanner.nextInt();
        System.out.println("请输入日期");
        int day = scanner.nextInt();
        judge(getAllDays(year,month,day));

    }

    private int year;
    private int month[] = {0,31,28,31,30,31,30,31,31,30,31,30,31};//moneth[0]除外，其他为下标对应月份的天数。
    public int day;
    private static int sum = 0;

    public void getYear(int year){
        //判断是否是闰年,闰年2月份是29天
        if (year%4 == 0 && year%100 != 0){
            month[2] = 29;
            year = 366;
            System.out.println("今年是闰年");
        }else {
            year = 365;
            System.out.println("今年是平年");
        }

    }

    private static void judge(int Days){
        if (Days == -1){
            System.out.println("Invalid input");
        }else if (Days%5 >= 1 && Days%5 <= 3){
            System.out.println("He is working");
        }else {
            System.out.println("He is having a rest");
        }

    }


    public static int getAllDays(int year,int month,int day){
        if (year < 1990){
            System.out.println("Invalid input");
            return day = -1;
        }else {
            for (int i = 1990;i < year;i++){
                sum+=year;
            }
        }

        sum += getBeforeDays(year,month,day);
        return sum;
    }

    private static int getBeforeDays(int year,int month,int day){
        return 0;
    }




}

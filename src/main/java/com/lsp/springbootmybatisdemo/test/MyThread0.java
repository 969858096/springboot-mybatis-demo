package com.lsp.springbootmybatisdemo.test;

/**
 * @program: springboot-mybatis-demo
 * @description:
 * @author: lsp
 * @create: 2019-12-31 10:07
 * @version:1.0
 **/
class Student {
    private String userName;
    private String gender;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}

class IntThread extends Thread {
    private Student student;

    public IntThread(Student student) {
        this.student = student;
    }

    @Override
    public void run() {
        int count = 0;
        while (true) {
            synchronized (student){
                if (count == 0) {
                    student.setUserName("lsp");
                    student.setGender("男");
                } else {
                    student.setUserName("mzl");
                    student.setGender("女");
                }
            }
            count = (count + 1) % 2;//结果是0或者是1
        }
    }
}

class OutThread extends Thread {
    private Student student;

    public OutThread(Student student) {
        this.student = student;
    }

    @Override
    public void run() {
       while (true){
           try {
               Thread.currentThread().sleep(500);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           synchronized (student){
              System.out.println("姓名="+student.getUserName()+",性别="+student.getGender());
          }
       }
    }
}

public class MyThread0 {
    public static void main(String[] args) {
        Student student = new Student();
        IntThread intThread = new IntThread(student);
        OutThread outThread = new OutThread(student);
        intThread.start();
        outThread.start();
    }
}

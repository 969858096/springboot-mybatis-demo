package com.lsp.springbootmybatisdemo.test.thread.future;

/**
 * @FileName: Main
 * @Description:
 * @AuthOr: lsp
 * @Date: 2019/12/29 22:32
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("main线程开启");
        FutureClient futureClient = new FutureClient();
        Data request = futureClient.request("969858096");
        System.out.println("main.数据发送成功.");
        System.out.println("主线程执行其他任务");
        String result = request.getResult();
        System.out.println("获得的数据是="+result);
    }
}

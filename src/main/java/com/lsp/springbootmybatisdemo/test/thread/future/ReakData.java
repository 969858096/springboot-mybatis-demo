package com.lsp.springbootmybatisdemo.test.thread.future;

/**
 * @FileName: ReakData
 * @Description:
 * @AuthOr: lsp
 * @Date: 2019/12/29 22:04
 */
//获取真实数据
public class ReakData extends Data{

    private String result;

    public ReakData(String data) {
        System.out.println("正在使用data进行网络请求，data:"+data+",开始...");
        try{
            //模仿业务操作耗时
            Thread.sleep(3000);
        }catch (Exception e){
            throw new NullPointerException("请求不到内容");
        }
        System.out.println("操作执行完毕。。。，获取到结果");
        this.result = "lsp";
    }

    @Override
    public String getResult() {
        return result;
    }
}

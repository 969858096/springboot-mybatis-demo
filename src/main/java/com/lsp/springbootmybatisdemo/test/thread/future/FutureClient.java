package com.lsp.springbootmybatisdemo.test.thread.future;

/**
 * @FileName: FutureClient
 * @Description:
 * @AuthOr: lsp
 * @Date: 2019/12/29 22:23
 */
public class FutureClient {

    public Data request(String requestData){
        FutureData futureData = new FutureData();
        new Thread(new Runnable() {
            @Override
            public void run() {
                ReakData reakData = new ReakData("969858096");
                futureData.setReData(reakData);
            }
        }).start();

        return futureData;
    }
}

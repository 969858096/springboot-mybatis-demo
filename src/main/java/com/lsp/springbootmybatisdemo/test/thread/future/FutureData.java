package com.lsp.springbootmybatisdemo.test.thread.future;

/**
 * @FileName: FutureData
 * @Description:
 * @AuthOr: lsp
 * @Date: 2019/12/29 21:58
 */
public class FutureData extends Data {
    private boolean FLAG = false;
    private ReakData reakData;

    //读取线程数据
    public synchronized void setReData(ReakData reData) {
        //如果获取到数据  直接返回结果
        if (FLAG) {
            return;
        } else {
            this.reakData = reData;
            FLAG = true;
            notify();
        }
    }

    @Override
    public synchronized String getResult() {
        while (!FLAG) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        return reakData.getResult();
    }
}

package com.lsp.springbootmybatisdemo.test.thread.disruptor.entity;

/**
 * @FileName: LongEven
 * @Description:表示生产者与消费者传递的数据类型
 * @AuthOr: lsp
 * @Date: 2020/1/1 16:06
 */
public class LongEven {

    private Long value;

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }
}

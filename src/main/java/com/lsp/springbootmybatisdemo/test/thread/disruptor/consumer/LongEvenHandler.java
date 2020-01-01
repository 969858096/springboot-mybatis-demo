package com.lsp.springbootmybatisdemo.test.thread.disruptor.consumer;

import com.lmax.disruptor.EventHandler;
import com.lsp.springbootmybatisdemo.test.thread.disruptor.entity.LongEven;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @FileName: LongEvenHandler
 * @Description: 获取消费者给生产者推送的数据
 * @AuthOr: lsp
 * @Date: 2020/1/1 16:12
 */
public class LongEvenHandler implements EventHandler<LongEven> {
    private static final Logger log = LoggerFactory.getLogger(LongEvenHandler.class);
    @Override
    public void onEvent(LongEven longEven, long l, boolean b) throws Exception {
        log.info("消费者获取生产者的数据，even="+longEven.getValue());
    }
}

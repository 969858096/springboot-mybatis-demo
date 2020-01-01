package com.lsp.springbootmybatisdemo.test.thread.disruptor.producer;

import com.lmax.disruptor.RingBuffer;
import com.lsp.springbootmybatisdemo.test.thread.disruptor.entity.LongEven;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.ByteBuffer;

/**
 * @FileName: LongEvenProducer
 * @Description:数据生产者
 * @AuthOr: lsp
 * @Date: 2020/1/1 16:39
 */
public class LongEvenProducer {
    private static final Logger log = LoggerFactory.getLogger(LongEvenProducer.class);
    //传入容器
    RingBuffer<LongEven> ringBuffer;

    public LongEvenProducer(RingBuffer<LongEven> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    public void onData(ByteBuffer byteBuffer){
        //获取环形数组的下标位置
        long sequ = ringBuffer.next();
        try {
            //获取下标对应的空间
            LongEven longEven = ringBuffer.get(sequ);
            //存入数据
            longEven.setValue(byteBuffer.getLong(0));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            log.info("生产者发送数据");
            ringBuffer.publish(sequ);
        }


    }
}

package com.lsp.springbootmybatisdemo.test.thread.disruptor.factory;

import com.lmax.disruptor.EventFactory;
import com.lsp.springbootmybatisdemo.test.thread.disruptor.entity.LongEven;

/**
 * @FileName: LongEvenFactory
 * @Description:  实例化LongEven对象
 * @AuthOr: lsp
 * @Date: 2020/1/1 16:09
 */
public class LongEvenFactory implements EventFactory<LongEven> {
    @Override
    public LongEven newInstance() {
        return new LongEven();
    }
}

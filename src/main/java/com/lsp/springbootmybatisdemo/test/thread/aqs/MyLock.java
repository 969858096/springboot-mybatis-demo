package com.lsp.springbootmybatisdemo.test.thread.aqs;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @FileName: MyLock
 * @Description:
 * @AuthOr: lsp
 * @Date: 2020/1/8 21:09
 */
public class MyLock implements Lock {
    private Helper helper = new Helper();

    @Override
    public void lock() {
        helper.tryAcquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        helper.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return helper.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return helper.tryAcquireNanos(1,unit.toNanos(time));
    }

    @Override
    public void unlock() {
        helper.release(1);
    }


    @Override
    public Condition newCondition() {
        return helper.newCondition();
    }

    private class Helper extends AbstractQueuedSynchronizer{
        @Override
        protected boolean tryAcquire(int args){
            int state = getState();
            if (state == 0){
                if (compareAndSetState(0,args)){
                    setExclusiveOwnerThread(Thread.currentThread());
                    return true;
                }
            }
            return false;
        }

        @Override
        protected boolean tryRelease(int args){
            //锁的获取和释放肯定是一一对应的，那么调用此方法的线程一定是当前线程
            if (Thread.currentThread() != getExclusiveOwnerThread()){
                throw new RuntimeException();
            }
            int state = getState() - args;
            boolean flag = false;
            if (state == 0){
                setExclusiveOwnerThread(null);
                flag = true;
            }
            setState(state);
            return flag;
        }

        Condition newCondition(){
            return new AbstractQueuedSynchronizer.ConditionObject();
        }
    }
}

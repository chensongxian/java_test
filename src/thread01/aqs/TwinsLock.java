package thread01.aqs;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 共享锁
 * 设计一个同步工具，该工具在同一时刻，只能有两个线程能够并行访问，超过限制的其他线程进入阻塞状态
 * @Author: csx
 * @Date: 2018/01/10
 */
public class TwinsLock implements Lock{
    public static class Sync extends AbstractQueuedSynchronizer{

        private static final long serialVersionUID = 4673356570548363873L;

        Sync(int count){
            if(count<=0){
                throw new IllegalArgumentException("count must large than zero.");
            }
            setState(2);
        }

        @Override
        protected int tryAcquireShared(int reduceCount) {
            for(;;){
                int current=getState();
                int newCount=current-reduceCount;
                if(newCount<0||compareAndSetState(current,newCount)){
                    return newCount;
                }
            }
        }

        @Override
        protected boolean tryReleaseShared(int returnCount) {
            for(;;){
                int current=getState();
                int newCount=current+returnCount;
                if(compareAndSetState(current,newCount)){
                    return true;
                }
            }
        }
    }

    public final Sync sync=new Sync(2);
    @Override
    public void lock() {
        sync.acquireShared(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireSharedInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return sync.tryAcquireShared(1)>=0;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireSharedNanos(1,unit.toNanos(time));
    }

    @Override
    public void unlock() {
        sync.releaseShared(1);
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}

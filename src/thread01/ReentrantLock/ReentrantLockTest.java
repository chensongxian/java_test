package thread01.ReentrantLock;

import org.junit.Test;

import java.util.Collection;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: ReentrantLock公平锁和非公平锁的测试
 * @Author: csx
 * @Date: 2018/01/10
 */
public class ReentrantLockTest {
    private static Lock fairLock = new ReentrantLock2(true);
    private static Lock unfairLock = new ReentrantLock2();

    @Test
    public void fair() {
        System.out.println("fair version");
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new Job(fairLock));
            thread.setName("" + i);
            thread.start();
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void unfair() {
        System.out.println("unfair version");
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new Job(unfairLock));
            thread.setName("" + i);
            thread.start();
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static class Job implements Runnable {
        private Lock lock;
        public Job(Lock lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                lock.lock();
                try {
                    System.out.println("Lock by:"
                            + Thread.currentThread().getName()+ " and "
                            + ((ReentrantLock2) lock).getQueuedThreads()
                    );
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    public static class ReentrantLock2 extends ReentrantLock{

        public ReentrantLock2() {
        }

        public ReentrantLock2(boolean b) {
            super(b);
        }

        @Override
        protected Collection<Thread> getQueuedThreads() {
            return super.getQueuedThreads();
        }
    }
}

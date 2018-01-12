package thread01.lock;

import org.junit.Test;
import thread01.lock.TwinsLock;

import java.util.concurrent.locks.Lock;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 共享锁测试
 * @Author: csx
 * @Date: 2018/01/10
 */
public class TwinsLockTest {
    @Test
    public void test() {
        final Lock lock = new TwinsLock();

        class Worker extends Thread {
            @Override
            public void run() {
                while (true) {
                    lock.lock();

                    try {
                        Thread.sleep(1000L);
                        System.out.println(Thread.currentThread());
                        Thread.sleep(1000L);
                    } catch (Exception ex) {

                    } finally {
                        lock.unlock();
                    }
                }
            }
        }

        for (int i = 0; i<=10; i++) {
            Worker w = new Worker();
            w.start();
        }

        new Thread() {
            @Override
            public void run() {
                while (true) {

                    try {
                        Thread.sleep(200L);
                        System.out.println();
                    } catch (Exception ex) {

                    }
                }
            }
        }.start();

        try {
            Thread.sleep(20000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

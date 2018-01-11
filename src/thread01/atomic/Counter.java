package thread01.atomic;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018/01/11
 */
public class Counter {
    private AtomicInteger atomicI=new AtomicInteger(0);
    private int i=0;

    public static void main(String[] args) {
        final Counter cas=new Counter();
        List<Thread> ts=new ArrayList<>(600);
        long start=System.currentTimeMillis();
        for(int i=0;i<100;i++){
            Thread t=new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int i=0;i<10000;i++){
                        cas.safeCount();
                        cas.count();
                    }
                }
            });
            ts.add(t);
        }
        for(Thread t:ts){
            t.start();
        }
        for(Thread t:ts){
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(cas.i);
        System.out.println(cas.atomicI.get());
        System.out.println(System.currentTimeMillis()-start);
    }

    /**
     * 使用CAS实现线程安全计数器
     */
    private void safeCount() {
        for (;;) {
            int i = atomicI.get();
            boolean suc = atomicI.compareAndSet(i, ++i);
            if (suc) {
                break;
            }
        }
    }

    /**
     * 非线程安全计数器
     */
    private void count() {
        i++;
    }
}

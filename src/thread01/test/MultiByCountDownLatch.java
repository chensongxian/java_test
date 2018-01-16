package thread01.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018/01/16
 */
public class MultiByCountDownLatch {
    public static void main(String[] args) {
        Lock lock=new ReentrantLock();
        Condition subCondition=lock.newCondition();

        ExecutorService executor= Executors.newFixedThreadPool(3);

        final Common2 common=new Common2(lock,subCondition);
        executor.execute(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<50;i++){
                    common.sub(i);
                }
            }
        });
        executor.shutdown();

        for(int i=0;i<50;i++){
            common.main(i);
        }
    }
}

class Common2{
    private boolean flag=true;

    private Lock lock;
    private Condition subCondition;

    public Common2(Lock lock, Condition subCondition) {
        this.lock = lock;
        this.subCondition = subCondition;
    }


    public void sub(int i){
        lock.lock();
        try {
            if (!flag){
                try {
                    subCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for(int n=1;n<=10;n++){
                System.out.println("子线程:"+n+" 循环");
            }
            flag=false;
            subCondition.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void main(int i){
        lock.lock();
        try {
            if (flag){
                try {
                    subCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for(int n=1;n<=100;n++){
                System.out.println("主线程:"+n+" 循环");
            }
            flag=true;
            subCondition.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}


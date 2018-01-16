package stack_queue;

import java.util.Timer;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 * ArrayBlockingQueue队列
 * 特点:
 * 基于定长数组，所以是有界队列
 * 内部维持一把锁，两个条件(notFull和notEmpty)
 * @Author: csx
 * @Date: 2018/01/16
 */
public class UseArrayBlockQueue {
    public static void main(String[] args) throws InterruptedException {
        final ArrayBlockingQueue<Integer> queue=new ArrayBlockingQueue<Integer>(10,true);
        ExecutorService executors = Executors.newFixedThreadPool(10);
        executors.execute(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<100;i++){
                    try {
                        System.out.println("压入数据:"+i);
                        queue.put(i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        executors.execute(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<100;i++){
                    try {
                        System.out.println("取出数据:"+queue.take());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

    }
}

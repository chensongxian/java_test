package stack_queue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @author: csx
 * @Date: 2018-01-16
 */
public class UseSynchronousQueue {
    public static void main(String[] args) {
        SynchronousQueue<Integer> synchronousQueue=new SynchronousQueue<>();

        ExecutorService executor = Executors.newFixedThreadPool(10);


        executor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("取出元素:"+synchronousQueue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        executor.execute(new Runnable() {
            @Override
            public void run() {
                synchronousQueue.add(1);
            }
        });
    }
}

package stack_queue;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018/01/16
 */
public class UseConcurrentLinkedQueue {
    public static void main(String[] args) {
        final ConcurrentLinkedQueue<Integer> queue=new ConcurrentLinkedQueue<>();

        ExecutorService executors=Executors.newFixedThreadPool(10);
        executors.execute(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<1000;i++){
                    System.out.println("插入数据:"+i);
                    queue.offer(i);
                }
            }
        });

        executors.execute(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<1000;i++){
                    System.out.println("取出数据:"+queue.poll());
                }
            }
        });
    }
}

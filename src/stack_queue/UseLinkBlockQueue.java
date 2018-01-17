package stack_queue;

import java.util.concurrent.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 * LinkBlockingQueue队列
 * 特点:
 * 基于链表的有界队列，值得注意的是默认情况下队列长度为Integer.MAX_VALUE，可以自己设定长度
 * 内部维持了两把锁（takeLock和putLock）,这意味着LinkBlockingQueue可以同一时刻两个线程可以一边读一边写
 * 内部维持了连个条件(notFull和notEmpty)
 * @author: csx
 * @Date: 2018-01-16
 */
public class UseLinkBlockQueue {
    public static void main(String[] args) {
        final LinkedBlockingQueue<Integer> linkedBlockingQueue=new LinkedBlockingQueue<>(10);

        ExecutorService executor = Executors.newFixedThreadPool(10);
        executor.execute(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<100;i++){
                    try {
                        System.out.println("压入数据:"+i);
                        linkedBlockingQueue.put(i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        executor.execute(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;i++){
                    try {
                        System.out.println("读取数据:"+linkedBlockingQueue.take());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });



    }
}

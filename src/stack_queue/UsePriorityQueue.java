package stack_queue;


import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 * 线程不安全的优先级队列PriorityQueue，内部维持了一个二叉堆（小顶堆或大顶堆）
 * @Author: csx
 * @Date: 2018/01/16
 */
public class UsePriorityQueue {
    public static void main(String[] args) {
        PriorityQueue<Task> q=new PriorityQueue<>();

        Task t1 = new Task();
        t1.setId(3);
        t1.setName("id为3");
        Task t2 = new Task();
        t2.setId(4);
        t2.setName("id为4");
        Task t3 = new Task();
        t3.setId(1);
        t3.setName("id为1");

        q.add(t1);
        q.add(t2);
        q.add(t3);

        System.out.println("容器：" + q);
        System.out.println(q.peek().getId());
        System.out.println("容器：" + q);
    }
}

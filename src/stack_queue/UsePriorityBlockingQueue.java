package stack_queue;

import thread01.queue.*;

import java.util.concurrent.PriorityBlockingQueue;
/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 * PriorityBlockingQueue
 * 特点:
 * 内部是一个二叉堆的结构，可以是大顶堆或者小顶堆
 * 无界队列
 * 内部维持一把锁，一个notEmpty条件,使用take方法时，队列为空会阻塞
 * @Author: csx
 * @Date: 2018/01/16
 */
public class UsePriorityBlockingQueue {

	
	public static void main(String[] args) throws Exception{
		
		
		PriorityBlockingQueue<thread01.queue.Task> q = new PriorityBlockingQueue<thread01.queue.Task>();
		
		thread01.queue.Task t1 = new thread01.queue.Task();
		t1.setId(3);
		t1.setName("id为3");
		thread01.queue.Task t2 = new thread01.queue.Task();
		t2.setId(4);
		t2.setName("id为4");
		thread01.queue.Task t3 = new thread01.queue.Task();
		t3.setId(1);
		t3.setName("id为1");
		
		//return this.id > task.id ? 1 : 0;
		q.add(t1);	//3
		q.add(t2);	//4
		q.add(t3);  //1
		
		// 1 3 4
		System.out.println("容器：" + q);
		System.out.println(q.take().getId());
		System.out.println(q.take().getId());
		System.out.println(q.take().getId());
		System.out.println("------阻塞-----");
		System.out.println(q.take().getId());
		System.out.println(q.take().getId());
		System.out.println("容器：" + q);
//		System.out.println(q.take().getId());
//		System.out.println(q.take().getId());
		

		
	}
}

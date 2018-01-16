package stack_queue;

import thread01.queue.WangBa;
import thread01.queue.Wangmin;

import java.util.concurrent.DelayQueue;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 * DelayQueue队列
 * 特点：
 * 内部基于PriorityQueue,所装载元素必须实现Delayed
 *
 * @author: csx
 * @Date: 2018-01-16
 */
public class UseDelayQueue implements Runnable{
    private DelayQueue<Wangmin> queue=new DelayQueue<>();

    private boolean yinye=true;

    public void shangji(String name,String id,int money){
        Wangmin man = new Wangmin(name, id, 1000 * money + System.currentTimeMillis());
        System.out.println("网名"+man.getName()+" 身份证"+man.getId()+"交钱"+money+"块,开始上机...");
        this.queue.add(man);
    }

    public void xiaji(Wangmin man){
        System.out.println("网名"+man.getName()+" 身份证"+man.getId()+"时间到下机...");
    }


    public static void main(String[] args) {
        System.out.println("网吧开始营业");
        WangBa siyu=new WangBa();
        Thread thread=new Thread(siyu);
        thread.start();

        siyu.shangji("路人甲", "123", 1);
        siyu.shangji("路人乙", "234", 10);
        siyu.shangji("路人丙", "345", 5);
    }

    @Override
    public void run() {
        while (yinye){
            Wangmin man = null;
            try {
                man = queue.take();
                xiaji(man);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

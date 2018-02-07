package thread01.sync006;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 用对象当锁时，普通对象和静态对象区别
 * @Author: csx
 * @Date: 2018/02/07
 */
public class ObjectLock2 implements Runnable{
    private static final Object lock=new Object();

    private static int i=5;

    @Override
    public void run() {
        synchronized (lock){
            i--;
            System.out.println(Thread.currentThread().getName()+" | "+i);
        }
    }

    public static void main(String[] args) {
        Thread t1=new Thread(new ObjectLock2(),"tag1");
        Thread t2=new Thread(new ObjectLock2(),"tag2");
        Thread t3=new Thread(new ObjectLock2(),"tag3");
        Thread t4=new Thread(new ObjectLock2(),"tag4");
        Thread t5=new Thread(new ObjectLock2(),"tag5");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}

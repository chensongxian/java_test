package thread01.deadlock;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 死锁测试
 * @Author: csx
 * @Date: 2018/01/10
 */
public class DeadLockDemo {
    /**
     * A锁
     */
    private static String A="A";
    /**
     * B锁
     */
    private static String B="B";

    public static void main(String[] args) {
        new DeadLockDemo().deadLock();
    }

    public void deadLock(){
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (A){
                    try {
                        System.out.println("死锁");
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (B){
                        System.out.println("t1");
                    }
                }
            }
        });

        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (B){
                    synchronized (A){
                        System.out.println("t2");
                    }
                }
            }
        });
        t1.start();
        t2.start();
    }
}

package thread01.sync006;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: synchronized代码块对字符串的锁，注意String常量池的缓存功能
 * @Author: csx
 * @Date: 2018-01-06
 */
public class StringLock {
    public void method() {
        /*
         * new String("字符串常量")
         * 字符串引用是一个常量,是同一个引用
         * 所以一直是t1开始，t1结束
         */
        synchronized ("字符串常量") {
            try {
                while(true){
                    System.out.println("当前线程 : "  + Thread.currentThread().getName() + "开始");
                    Thread.sleep(1000);
                    System.out.println("当前线程 : "  + Thread.currentThread().getName() + "结束");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        final StringLock stringLock = new StringLock();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                stringLock.method();
            }
        },"t1");
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                stringLock.method();
            }
        },"t2");

        t1.start();
        t2.start();
    }
}

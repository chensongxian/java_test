package thread01.sync005;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: synchronized异常
 * @Author: csx
 * @Date: 2018-01-06
 */
public class SyncException {
    private int i = 0;
    public synchronized void operation(){
        while(true){
            try {
                i++;
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName() + " , i = " + i);
                if(i == 20){
                    //Integer.parseInt("a");
                    throw new RuntimeException();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        final SyncException se = new SyncException();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                se.operation();
            }
        },"t1");
        t1.start();
    }
}

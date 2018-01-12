package thread01.threadUtils;

import java.util.concurrent.CyclicBarrier;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: CyclicBarrier使用
 * @Author: csx
 * @Date: 2018/01/12
 */
public class CyclicBarrierTest {
    static CyclicBarrier c = new CyclicBarrier(2);

    public static void main(String[] args) {
        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    c.await();
                } catch (Exception e) {

                }
                System.out.println(1);
            }
        }).start();

        try {
            c.await();
        } catch (Exception e) {

        }
        System.out.println(2);
    }
}

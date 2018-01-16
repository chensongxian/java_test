package thread01.threadPool.ThreadPoolExecutor;

import java.util.concurrent.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018/01/16
 */
public class UserFixedThreadPool {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executors = Executors.newSingleThreadExecutor();

        for(int i = 0; i<100; i++){
            final int finalI = i;
            executors.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("测试一下:"+ finalI);
                }
            });
        }

    }
}

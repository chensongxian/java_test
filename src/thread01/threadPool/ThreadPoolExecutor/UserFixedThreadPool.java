package thread01.threadPool.ThreadPoolExecutor;

import java.util.Timer;
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
        ExecutorService executors = Executors.newFixedThreadPool(10);


        FutureTask<String> future=new FutureTask<String>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "返回结果";
            }
        });
        executors.submit(future);
        System.out.println(future.get());


    }
}

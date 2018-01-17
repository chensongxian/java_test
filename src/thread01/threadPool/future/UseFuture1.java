package thread01.threadPool.future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018/01/17
 */
public class UseFuture1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask=new FutureTask<String>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "返回结果";
            }
        });

        futureTask.run();
        boolean cancelResult=futureTask.cancel(false);
        System.out.println("cancel返回结果:"+cancelResult);
        Thread.sleep(1000);
        System.out.println(futureTask.get());
    }
}

package thread01.threadPool.future;

import java.util.concurrent.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018/01/17
 */
public class UseFuture2 implements Callable<String>{
    private String para;

    public UseFuture2(String para) {
        this.para = para;
    }

    @Override
    public String call() throws Exception {
        return "返回结果:"+para;
    }

    public static void main(String[] args) {
        String query="查询参数";
        FutureTask<String> future=new FutureTask<String>(new UseFuture2(query));

        ExecutorService executor = Executors.newFixedThreadPool(10);

        executor.submit(future);

        try {
            Thread.sleep(1000);
            System.out.println("结果:"+future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

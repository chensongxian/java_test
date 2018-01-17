package thread01.threadPool.future;

import java.util.concurrent.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018/01/17
 */
public class ConcurrentTask {
    private final ConcurrentHashMap<Object,Future<String>> taskCache=new ConcurrentHashMap<>();


    public String exeTask(final String taskName){
        while (true){
            Future<String> future=taskCache.get(taskName);
            if(future==null){
                Callable<String> call=new Callable<String>() {
                    @Override
                    public String call() throws Exception {
                        return taskName;
                    }
                };

                FutureTask<String> futureTask=new FutureTask<String>(call);
                future=taskCache.putIfAbsent(taskName,futureTask);
                if(future==null){
                    future=futureTask;
                    futureTask.run();
                }
            }

            try {
                return future.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ConcurrentTask concurrentTask=new ConcurrentTask();
        for(int i=0;i<10;i++){
            String result=concurrentTask.exeTask(""+i);
            System.out.println(result);
        }
    }
}

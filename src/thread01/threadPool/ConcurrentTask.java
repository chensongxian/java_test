package thread01.threadPool;

import java.util.concurrent.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018/01/12
 */
public class ConcurrentTask {
    private final ConcurrentMap<Object, Future<String>> taskCache = new ConcurrentHashMap<Object, Future<String>>();

    private String executionTask(final String taskName) throws ExecutionException, InterruptedException {
        while (true) {
            //1.1,2.1
            Future<String> future = taskCache.get(taskName);
            if (future == null) {
                Callable<String> task = new Callable<String>() {
                    @Override
                    public String call() throws InterruptedException {
                        //......
                        return taskName;
                    }
                };
                //1.2创建任务
                FutureTask<String> futureTask = new FutureTask<String>(task);
                //1.3
                future = taskCache.putIfAbsent(taskName, futureTask);
                if (future == null) {
                    future = futureTask;
                    futureTask.run(); //1.4执行任务
                }
            }

            try {
                //1.5,2.2线程在此等待任务执行完成
                return future.get();
            } catch (CancellationException e) {
                taskCache.remove(taskName, future);
            }
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ConcurrentTask concurrentTask=new ConcurrentTask();
        String name=concurrentTask.executionTask("test");
        System.out.println(name);
    }
}

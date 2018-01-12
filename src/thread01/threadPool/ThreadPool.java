package thread01.threadPool;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @author: csx
 * @Date: 2018-01-11
 */
public interface ThreadPool<Job extends Runnable> {
    /**
     * 执行一个job,这个job需要实现runner
     * @param job
     */
    void execute(Job job);

    /**
     * 关闭线程池
     */
    void shutdown();

    /**
     * 增加工作者线程
     * @param num
     */
    void addWorker(int num);

    /**
     * 减少工作者线程
     * @param num
     */
    void removeWorker(int num);

    /**
     * 获得正在等待执行任务的线程数量
     */
    int getJobSize();

}

package thread01.threadPool.custom;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018/01/12
 */
public class DefaultThreadPool<Job extends Runnable> implements ThreadPool<Job>{
    /**
     * 线程池最大数量
     */
    private static final int MAX_WORKER_NUMBERS=10;
    /**
     * 线程池最小数量
     */
    private static final int MIN_WORKER_NUMBERS=1;
    /**
     * 线程池默认数量
     */
    private static final int DEFAULT_WORKER_NUMBERS=5;

    /**
     * 工作列表
     */
    private final LinkedList<Job> jobs=new LinkedList<>();
    /**
     * 工作者列表
     */
    private final List<Worker> workers= Collections.synchronizedList(new ArrayList<Worker>());
    /**
     * 工作者线程数量
     */
    private int workerNum=DEFAULT_WORKER_NUMBERS;
    /**
     * 线程编号生成
     */
    private AtomicLong threadNum=new AtomicLong();

    public DefaultThreadPool() {
        initializeWokers(DEFAULT_WORKER_NUMBERS);
    }

    public DefaultThreadPool(int num) {
        this.workerNum = num > MAX_WORKER_NUMBERS?MAX_WORKER_NUMBERS : num < MIN_WORKER_NUMBERS?MIN_WORKER_NUMBERS : num;
        initializeWokers(this.workerNum);
    }

    @Override
    public void execute(Job job) {
        if(job!=null){
            synchronized (jobs){
                jobs.addLast(job);
                jobs.notify();
            }
        }
    }

    @Override
    public void shutdown() {
        for(Worker worker:workers){
            worker.shutdown();
        }
    }

    @Override
    public void addWorker(int num) {
        synchronized (jobs){
            if(num+this.workerNum>MAX_WORKER_NUMBERS){
                num=MAX_WORKER_NUMBERS-this.workerNum;
            }
            initializeWokers(num);
            this.workerNum+=num;
        }
    }

    @Override
    public void removeWorker(int num) {
        synchronized (jobs){
            if(num>this.workerNum){
                throw new IllegalArgumentException("beyond workNum");
            }
            int count=0;
            while (count<num){
                Worker worker=workers.get(count);
                if(workers.remove(worker)){
                    worker.shutdown();
                    count++;
                }
            }
            this.workerNum-=count;
        }
    }

    @Override
    public int getJobSize() {
        return jobs.size();
    }

    /**
     * 初始化线程工作者
     * @param num
     */
    private void initializeWokers(int num) {
        for (int i = 0; i < num; i++) {
            Worker worker = new Worker();
            workers.add(worker);
            Thread thread = new Thread(worker, "ThreadPool-Worker-" + threadNum.
                    incrementAndGet());
            thread.start();
        }
    }

    /**
     * 工作者，负责消费任务
     */
    class Worker implements Runnable{
        private volatile boolean isRunning=true;
        @Override
        public void run() {
            while (isRunning){
                Job job=null;
                synchronized (jobs){
                    while (jobs.isEmpty()){
                        try {
                            jobs.wait();
                        } catch (InterruptedException e) {
                            // 感知到外部对WorkerThread的中断操作，返回
                            Thread.interrupted();
                            return;
                        }
                    }
                    job=jobs.removeFirst();
                }
                if(job!=null){
                    try {
                        job.run();
                    }catch (Exception e){

                    }
                }
            }
        }

        public void shutdown(){
            isRunning=false;
        }
    }
}

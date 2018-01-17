package thread01.forkjoin;

import sun.dc.pr.PRError;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018/01/17
 */
public class ForkJoinNoReturn extends RecursiveAction{

    private static final int THRESHOLD=2;

    private int start;

    private int end;

    public ForkJoinNoReturn(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected void compute() {
        int sum=0;
        boolean canCompute=(end-start)<=THRESHOLD;
        if(canCompute){
            for(int i=start;i<=end;i++){
                sum+=i;
            }
        }else{
            int middle=(end+start)/2;
            ForkJoinNoReturn leftTask=new ForkJoinNoReturn(start,middle);
            ForkJoinNoReturn rightTask=new ForkJoinNoReturn(middle+1,end);

            leftTask.fork();
            rightTask.fork();

            leftTask.join();
            rightTask.join();
        }
        System.out.println(sum);
    }

    public static void main(String[] args) {
        ForkJoinPool pool=new ForkJoinPool();

        ForkJoinNoReturn forkJoinNoReturn=new ForkJoinNoReturn(1,10);

        pool.execute(forkJoinNoReturn);
    }
}

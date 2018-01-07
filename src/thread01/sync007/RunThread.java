package thread01.sync007;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: volatile关键字，线程之间的可见性
 * @Author: csx
 * @Date: 2018-01-07
 */
public class RunThread extends Thread{
    private  volatile boolean isRunning = true;
    private void setRunning(boolean isRunning){
        this.isRunning = isRunning;
    }

    @Override
    public void run(){
        System.out.println("进入run方法..");
        int i = 0;
        while(isRunning == true){
            //..
        }
        System.out.println("线程停止");
    }

    public static void main(String[] args) throws InterruptedException {
        RunThread rt = new RunThread();
        rt.start();
        Thread.sleep(1000);
        rt.setRunning(false);
        System.out.println("isRunning的值已经被设置了false");
    }
}

package thread01.test;

import sun.applet.Main;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 子线程循环10次，接着主线程循环100，接着又回到子线程循环10次，接着再回到主线程又循环100，如此循环50次
 * @Author: csx
 * @Date: 2018/01/10
 */
public class Multi {
    public static void main(String[] args) {
        final Common common=new Common();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=1;i<=50;i++) {
                    common.sub(i);
                }
            }
        }).start();

        for (int i=1;i<=50;i++){
            common.main(i);
        }
    }
}
class Common{
    private boolean flag=true;

    public synchronized void sub(int i){
        if (!flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for(int n=1;n<=10;n++){
            System.out.println("子线程:"+n+" 循环");
        }
        flag=false;
        this.notify();
    }

    public synchronized void main(int i){
        if (flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for(int n=1;n<=100;n++){
            System.out.println("主线程:"+n+" 循环");
        }
        flag=true;
        this.notify();
    }
}
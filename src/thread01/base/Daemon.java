package thread01.base;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 守护线程
 * @Author: csx
 * @Date: 2018/01/11
 */
public class Daemon {
    /**
     * main线程（非Daemon线程）在启动了线程DaemonRunner之后随着main方法执行完毕而终止，
     * 而此时Java虚拟机中已经没有非Daemon线程，虚拟机需要退出。Java虚拟机中的所有Daemon线程都需要立即
     * 终止，因此DaemonRunner立即终止，但是DaemonRunner中的finally块并没有执行
     * @param args
     */
    public static void main(String[] args) {
        Thread thread = new Thread(new DaemonRunner());
        thread.setDaemon(true);
        thread.start();
    }

    /**
     * 在构建Daemon线程时，不能依靠finally块中的内容来确保执行关闭或清理资源的逻辑
     */
    static class DaemonRunner implements Runnable {
        @Override
        public void run() {
            try {
                SleepUtils.second(100);
            } finally {
                System.out.println("DaemonThread finally run.");
            }
        }
    }
}

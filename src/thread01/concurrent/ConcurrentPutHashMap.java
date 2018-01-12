package thread01.concurrent;

import java.util.HashMap;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 * 并发下，HashMap测试
 * 在多线程环境下，使用HashMap进行put操作会引起死循环，导致CPU利用率接近100%，所
 * 以在并发情况下不能使用HashMap
 * @Author: csx
 * @Date: 2018/01/12
 */
public class ConcurrentPutHashMap {
    /**
     * HashMap在并发执行put操作时会引起死循环，是因为多线程会导致HashMap的Entry链表
     * 形成环形数据结构，一旦形成环形数据结构，Entry的next节点永远不为空，就会产生死循环获
     * 取Entry
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        final HashMap<String, String> map = new HashMap<String, String>(2);
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            map.put(UUID.randomUUID().toString(), "");
                        }
                    }, "ftf" + i).start();
                }
            }
        }, "ftf");
        t.start();
        t.join();
    }
}

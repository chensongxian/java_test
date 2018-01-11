package thread01.singleton;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 线程安全的懒汉模式
 * @Author: csx
 * @Date: 2018/01/11
 */
public class SafeLazyInitialization {
    private static Instance instance;

    /**
     * 虽然使用synchronized保证线程安全，但是加锁导致性能开销
     * synchronized操作只有第一次instance等于null时才调用
     * @return
     */
    public synchronized static Instance getInstance() {
        if (instance == null) {
            instance = new Instance();
        }
        return instance;
    }

    static class Instance {
    }
}

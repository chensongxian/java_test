package thread01.singleton;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 线程不安全的懒汉模式
 * @Author: csx
 * @Date: 2018/01/11
 */
public class UnsafeLazyInitialization {
    private static Instance instance;

    /**
     * 在多线程下可能B线程已经进入准备new实例，此时instance还是null的
     * 若此时A线程也进入，那么就不是单例了
     * @return
     */
    public static Instance getInstance() {
        //1：A线程执行
        if (instance == null) {
            //2：B线程执行
            instance = new Instance();
        }
        return instance;
    }

    static class Instance {
    }
}

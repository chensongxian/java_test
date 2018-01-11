package thread01.singleton;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 基于类初始化的解决方案
 * @Author: csx
 * @Date: 2018/01/11
 */
public class InstanceFactory {
    /**
     * JVM在类的初始化阶段（即在Class被加载后，且被线程使用之前），会执行类的初始化。在
     * 执行类的初始化期间，JVM会去获取一个锁。这个锁可以同步多个线程对同一个类的初始化
     */
    private static class InstanceHolder {
        public static Instance instance = new Instance();
    }

    public static Instance getInstance() {
        return InstanceHolder.instance; //这里将导致InstanceHolder类被初始化
    }

    static class Instance {
    }
}

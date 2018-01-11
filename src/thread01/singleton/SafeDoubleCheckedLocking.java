package thread01.singleton;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018/01/11
 */
public class SafeDoubleCheckedLocking {
    /*
     * 使用volatile禁止重排序
     * 注意:JDK1.5之后volatile才能完成禁止指令重排
     */
    private volatile static Instance instance;

    public static Instance getInstance() {
        if (instance == null) {
            synchronized (SafeDoubleCheckedLocking.class) {
                if (instance == null) {
                    //instance为volatile，现在没问题了
                    instance = new Instance();
                }
            }
        }
        return instance;
    }

    static class Instance {
    }
}

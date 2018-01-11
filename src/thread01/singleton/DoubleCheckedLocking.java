package thread01.singleton;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 双重检验锁
 * @Author: csx
 * @Date: 2018/01/11
 */
public class DoubleCheckedLocking {
    //2
    private static Instance instance;

    /**
     * 双重检验锁既解决了安全问题，也解决了锁同步的开销问题
     * 但是这种写法是由问题的，因为 instance = new Instance();不是一个原子性操作
     * 创建一个对象分为:
     * 1：分配对象的内存空间
     * 2：初始化对象
     * 3：设置instance指向刚分配的内存地址
     * 很可能,1、2、3步骤会发生指令重排
     * @return
     */
    public static Instance getInstance() { //3
        //4:第一次检查，
        if (instance == null) {
            //5:加锁,单例一般只需第一次判断null时才加锁,所以在第四步加一个null判断
            synchronized (DoubleCheckedLocking.class) {
                //6:第二次检查,反正同时进入第一个if的线程，得到锁之后再一次new实例
                if (instance == null) {
                    //7:问题的根源出在这里
                    instance = new Instance();
                }
            } //8
        } //9
        //10
        return instance;
    } //11

    static class Instance {
    }
}

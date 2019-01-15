package classLoader;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2019-01-15
 */
public class ClassLoaderTest {
    public static void main(String[] args) {
        System.out.println("BootstrapClassLoader加载Jar包路径: " + System.getProperty("sun.boot.class.path"));
        System.out.println("ExtClassLoader加载Jar包路径: " + System.getProperty("java.ext.dirs"));
        System.out.println("AppClassLoader加载Jar包路径: " + System.getProperty("java.class.path"));
    }

    public void print() {
        System.out.println("打印");
    }
}

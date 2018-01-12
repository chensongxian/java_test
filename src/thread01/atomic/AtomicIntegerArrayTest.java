package thread01.atomic;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: AtomicIntegerArray使用
 * @Author: csx
 * @Date: 2018/01/12
 */
public class AtomicIntegerArrayTest {
    static int[] value = new int[] { 1, 2 };

    static AtomicIntegerArray ai    = new AtomicIntegerArray(value);

    public static void main(String[] args) {
        ai.getAndSet(0, 3);
        System.out.println(ai.get(0));
        System.out.println(value[0]);
    }
}

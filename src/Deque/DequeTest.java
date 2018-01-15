package Deque;

import org.junit.Test;

import java.util.ArrayDeque;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 测试deque双端队列
 * @Author: csx
 * @Date: 2018/01/04
 */
public class DequeTest {
    @Test
    public void testArrayDeque(){
        ArrayDeque arrayDeque=new ArrayDeque();
        arrayDeque.addFirst("1");
//        System.out.println(arrayDeque);
    }
}

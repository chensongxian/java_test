package interger;

import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018/01/04
 */
public class IntegerTest {
    @Test
    public void testInteger(){
        Integer a=100;
        Integer b=100;
        Integer c=128;
        /*
            因为integer在-128到127之间不会再次创建对象，而会引用之前的对象，所有a==b为true
         */
        System.out.println(a==b);
        System.out.println(b==c);
    }
}

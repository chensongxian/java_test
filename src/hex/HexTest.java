package hex;

import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018/01/04
 */
public class HexTest {
    @Test
    public void testHex(){
        byte max=(byte) 0b01111111;
        byte min=(byte) 0b1000_0000;
        System.out.println("0b"+min+"|"+max);

        int a=(int)017;
        System.out.println(a);
        int b=(int)0xb;
        System.out.println(b);
    }

    @Test
    public void testAndOp(){
        int a=2&7;
        System.out.println(a);
        int b=-1;
        System.out.println(Integer.toBinaryString(b));
        System.out.println(Integer.toBinaryString(7));
        System.out.println(Integer.toBinaryString(-1&7));
    }
}

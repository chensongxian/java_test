package variable;

import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 变量转换
 * @author: csx
 * @Date: 2018/01/02
 */
public class VariableConvertTest {
    /**
     * 自动类型转换
     */
    @Test
    public void autoTypeConvert(){

        int x = 3;
        byte b = 5;
        //x与b相加时会自动转换成int类型
        x = x+b;
        System.out.println(x);
    }

    /**
     * 强制类型转换
     */
    @Test
    public void forcedTypeConvert(){
        byte b = 3;
        //b+200的结果会自动转换成int类型,再赋值给b会出现精度丢失，必须强制类型转换才不会报错
        b = (byte)(b+200);
        //结果:-53，203转换成byte之后只有8位二进制为11001011
        //第一位是1，所以为负数，求其补码为10110101,即-53
        System.out.println(b);
    }

    /**
     * 变量提升
     */
    @Test
    public void varHoisting(){
        byte b=3+7;
        byte b1=3;
        byte b2=7;
        //下面的一行代码会报错，因为b1与b2相加,因为不知道b1和b2是多少，会把b1和b2的结果自动提升为int类型
//        b=b1+b2;
        System.out.println(b);
    }
}

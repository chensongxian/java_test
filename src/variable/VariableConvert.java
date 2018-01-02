package variable;

import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 变量转换
 * @Author: csx
 * @Date: 2018-01-02
 */
public class VariableConvert {
    /**
     * 自动类型转换
     */
    @Test
    public void autoTypeConvert(){

        int x = 3;
        byte b = 5;
        //x与b相加时会自动转换成int类型
        System.out.println(x);
        x = x+b;
    }

    /**
     * 强制类型转换
     */
    @Test
    public void forcedTypeConvert(){
        byte b = 3;
        //b+200的结果会自动转换成int类型,再赋值给b会出现精度丢失，必须强制类型转换才不会报错
        b = (byte)(b+200);
        System.out.println(b);
    }
}

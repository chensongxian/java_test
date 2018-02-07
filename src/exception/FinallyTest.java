package exception;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018-01-17
 */
public class FinallyTest {
    public static void main(String[] args) {
        System.out.println(new FinallyTest().test());
    }

    public static int test() {
        int x = 1;
        try {
//            int result=1/0;
            return x;
        }catch (Exception e){
            x=5;
        } finally {
            ++x;
            System.out.println(x);
            return x;
        }
    }
}

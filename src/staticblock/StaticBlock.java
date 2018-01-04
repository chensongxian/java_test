package staticblock;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018/01/04
 */
public class StaticBlock {
    {
        System.out.println("构造代码块");
    }

    static {
        System.out.println("静态代码块");
    }
    public StaticBlock(){
        System.out.println("构造方法");
    }

    public static void main(String[] args) {
        StaticBlock staticBlock1=new StaticBlock();
        System.out.println("----------");
        StaticBlock staticBlock2=new StaticBlock();
    }
}

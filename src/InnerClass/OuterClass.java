package InnerClass;

import javax.sound.midi.Soundbank;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018/01/04
 */
public class OuterClass {
    public OuterClass(){
        System.out.println("外部类构造函数");
    }
    static class InnerClass{
        static final int cache[];
        private InnerClass(){
            System.out.println("静态内部类构造函数");
        }
        static {
            System.out.println("静态构造代码块");
            // high value may be configured by property
           int h=127;
           cache=new int[h];
           for(int i=0;i<h;i++){
               cache[i]=i;
           }
        }
    }

    public void print(int i){
        int val=InnerClass.cache[i];
        System.out.println(val);
    }
    public static void main(String[] args) {
        OuterClass outerClass=new OuterClass();
        outerClass.print(3);
        InnerClass innerClass=new InnerClass();
    }
}

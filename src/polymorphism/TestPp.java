package polymorphism;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018/01/04
 */
public class TestPp {
    public static void main(String[] args) {
          A a1 = new A();
          A a2 = new B();
          B b = new B();
          C c = new C();
          D d = new D();
//        System.out.println(a1.show(b));
//        System.out.println(a1.show(c));
//        System.out.println(a1.show(d));
//
//        System.out.println(a2.show(b));
//
//        System.out.println(a2.show(c));
        System.out.println(a2.show(d));
//        System.out.println(b.show(b));
//        System.out.println(b.show(c));
//        System.out.println(b.show(d));
    }
}

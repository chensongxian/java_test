package extend;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018/01/04
 */
public class TestConstruction {
    public static void main(String[] args) {
        /*
            子类Student创建对象时，会先创建父类构造方法
            下面一行代码，调用Student无参构造方法时，会默认添加一个父类的无参构造方法
         */
        Person p = new Student();
        Student s = new Student("a");
    }
}

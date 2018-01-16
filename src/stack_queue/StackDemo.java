package stack_queue;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 * 栈，LIFO，后进先出
 * Stack继承了Vector，现在java官方已经不推荐使用Stack，而是使用ArrayDeque
 * @Author: csx
 * @Date: 2018/01/16
 */
public class StackDemo {
    public static void main(String[] args) {
        Stack<String> stack=new Stack<>();
        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.push("4");
        stack.push("5");

        //peek方法,取栈顶元素,不移除
        System.out.println(stack.peek());
        System.out.println(stack.peek());

        //pop方法,取栈顶元素,同时移除
        System.out.println(stack.pop());
        System.out.println(stack.peek());
    }
}

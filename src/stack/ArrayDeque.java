package stack;

import java.util.Deque;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 * ArrayDeque,官方推荐用来替代stack
 * ArrayDeque也可以当成队列使用
 * @Author: csx
 * @Date: 2018/01/16
 */
public class ArrayDeque {
    public static void main(String[] args) {
        System.out.println("---------栈-----------");
        Deque<Integer> stack=new java.util.ArrayDeque<>();
        /*
         * 栈的使用方法
         */
        //向栈顶插入元素
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        //返回栈顶元素
        System.out.println(stack.peek());
        //移除并返回栈顶元素
        System.out.println(stack.pop());
        System.out.println(stack.peek());

        /*
         * 队列使用方法
         */
        System.out.println("---------队列-----------");
        Deque<Integer> queue=new java.util.ArrayDeque<>();
        //向队尾插入元素
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);

        //获取队首元素,不删除
        System.out.println(queue.peek());
        System.out.println(queue.peek());

        //获取并删除队首元素
        System.out.println(queue.poll());
        System.out.println(queue.peek());
    }
}

package datastructure.stack;

import java.util.Stack;

/**
 * @ClassName algorithm
 * @Author Songleen
 * @Date 2019/08/24/16:29
 *
 * 演示栈的基本使用
 */
public class StackTest {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();

        //入栈
        stack.add("Tom1");
        stack.add("Tom2");
        stack.add("Tom3");

        //出栈
        while (stack.size()>0){
            System.out.println(stack.pop());    //pop就是将栈顶的数据取出去
        }
    }
}

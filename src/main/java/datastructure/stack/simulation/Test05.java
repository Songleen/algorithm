package datastructure.stack.simulation;

/**
 * @ClassName algorithm
 * @Author Songleen
 * @Date 2019/08/25/11:10
 */
public class Test05 {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.showStack();
    }
}

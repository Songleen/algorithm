package datastructure.stack.simulation;

/**
 * @ClassName algorithm
 * @Author Songleen
 * @Date 2019/08/25/10:51
 */
public class ArrayStack {
    private int top = -1;
    private int[] stack;
    private int maxSize;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    //栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }

    //栈空
    public boolean isEmpty() {
        return top == -1;
    }

    //入栈
    public void push(int value) {
        if (isFull()) {
            System.out.println("栈已满");
            return;
        }
        top++;
        stack[top] = value;
    }

    //出栈
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈已空了");
        }
        int value = stack[top];
        top--;
        return value;
    }

    //获取栈顶值,不是出栈
    public int peek() {
        return stack[top];
    }

    //返回运算符的优先级,优先级由程序员决定,数字越大，优先级越高
    public int priority(int oper) {
        //在java中,int和char是可以混用的，因为char底层其实也是一个数字
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else if (oper == '(' || oper == ')') {
            return 2;
        } else {
            return -1;  //假定当前表达式只有+，-，*，/
        }
    }

    //判断是不是一个运算符
    public boolean isOper(char val) {
        return val == '+' || val == '-' || val == '*' ||
                val == '/' || val == '(' || val == ')';
    }

    //计算方法
    public int cal(int num1, int num2, int oper) {
        int res = 0;    //用于存放计算结果
        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;
    }


    //遍历栈，需要从栈顶开始
    public void showStack() {
        if (isEmpty()) {
            throw new RuntimeException("栈已经空了……");
        }
        while (top != -1) {
            int value = stack[top];
            top--;
            System.out.println(value);
        }
    }
}

package datastructure.stack.interfixToSuffix;

import datastructure.stack.simulation.ArrayStack;

/**
 * @ClassName algorithm
 * @Author Songleen
 * @Date 2021/04/16/21:28
 */
public class InterfixToSuffix2 {
    public static void main(String[] args) {
        String interfix2 = "1+((2+3)*4)-5";
        convert(interfix2);
    }

    private static void convert(String expression) {
        // 准备两个栈
        ArrayStack numStack = new ArrayStack(20);
        ArrayStack operStack = new ArrayStack(20);
        // 为了保存多位数，先声明一个字符串
        String keepNum = "";
        // 从左到右遍历表达式
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            // 1、如果是数字，则直接入数栈
            if (!numStack.isOper(ch)) {
                keepNum += ch;
                // 往后面去一位，看看是不是多位数
                int j = i;
                // 如果是最后一位，则直接入数栈
                if (i != expression.length() - 1) {
                    boolean isOper = numStack.isOper(expression.charAt(++j));
                    if (isOper) {
                        numStack.push(Integer.parseInt(keepNum));
                        keepNum = "";
                    }
                } else {
                    numStack.push(Integer.parseInt(keepNum));
                    keepNum = "";
                }

                // 2、是符号
            } else {
                // 如果符号栈为空或者为左括号则直接入符号栈
                if (operStack.isEmpty() || ch == '(') {
                    operStack.push(ch);
                    continue;
                }
                // 如果是右括号，则依次弹出符号栈的运算符，并压入数栈，直到遇到左括号
                if (ch == ')') {
                    while (true) {
                        int oper = operStack.peek();
                        if (oper == '(') {
                            operStack.pop();
                            break;
                        }
                        numStack.push(operStack.pop());
                    }
                    continue;
                }
                // 其它符号，则判断和符号栈栈顶的符号的优先级
                int top = operStack.peek();
                int curPrio = operStack.priority(ch);
                int headPrio = operStack.priority(top);
                if (curPrio > headPrio || top == '(') {
                    operStack.push(ch);
                } else {
                    // 若优先级<=栈顶操作符的优先级
                    while (!operStack.isEmpty() && curPrio <= headPrio) {
                        // 弹出栈顶的操作符，压入数栈
                        numStack.push(operStack.pop());
                        if (operStack.isEmpty()) {
                            break;
                        }
                        headPrio = operStack.priority(operStack.peek());
                    }
                    operStack.push(ch);
                }
            }
        }

        // 将符号栈的元素依次弹出加到数栈中
        while (!operStack.isEmpty()) {
            numStack.push(operStack.pop());
        }

        // 输出数栈
        numStack.showStack();
    }
}

package datastructure.stack.calculator;

import datastructure.stack.simulation.ArrayStack;

/**
 * @ClassName algorithm
 * @Author Songleen
 * @Date 2019/08/25/18:01
 *
 * 用栈来实现四则运算
 */
public class SyntheticCalculator {
    public static void main(String[] args) {
        String expression = "7*100-6+8/4";

        //创建两个栈
        ArrayStack numStack = new ArrayStack(10);
        ArrayStack operStack = new ArrayStack(10);

        //定义相关的变量
        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        //将每次扫描得到的char保存到ch
        char ch = ' ';
        String keepNum = "";
        //循环扫描expression
        while (true) {
            //依次得到expression的每个字符
            ch = expression.substring(index, index + 1).charAt(0);
            //1、如果是符号
            if (operStack.isOper(ch)) {
                //1.1、如果符号栈为空,则之直接入栈
                if (operStack.isEmpty()) {
                    operStack.push(ch);
                } else {
                    // 1.2、如果符号栈不为空，如果栈中优先级高，则先进行运算
                    int num = operStack.priority(ch);
                    int peekNum = operStack.priority(operStack.peek());
                    // 如果后一个运算符优先级低于前一个，则将前一个的进行计算再放到栈中
                    if (num <= peekNum) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.cal(num1, num2, oper);
                        //1.3、将计算结果入数栈
                        numStack.push(res);
                        //1.4、将当前的操作符入符号栈
                        operStack.push(ch);
                    } else {
                        operStack.push(ch);
                    }
                }
                //2、如果是数，则直接入栈
            } else {
                //2.1、在入栈前，应该先判断一下是不是一个多位数
                //处理多位数
                keepNum += ch;
                //2.2、如果ch已经是expression的最后一位，就直接入栈
                if (index == expression.length()-1){
                    numStack.push(Integer.parseInt(keepNum));
                }else {
                    //往后看一位，不是Index++
                    if (operStack.isOper(expression.substring(index+1, index+2).charAt(0))){
                        //如果后一位是运算符，就将当前数字入栈
                        numStack.push(Integer.parseInt(keepNum));
                        //将keepNum清空,很重要啊
                        keepNum = "";
                    }
                }
            }
            //让index加1,并判断是否扫描到expression的最后
            index++;
            if (index >= expression.length()) {
                break;
            }
        }

        //3、当表达式被扫描完毕，就顺序地从数栈和符号栈中pop出相应的数和符号，并运算
        while (true) {
            if (operStack.isEmpty()) {
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = numStack.cal(num1, num2, oper);
            //将每次运算的结果数再入数栈
            numStack.push(res);
        }

        //将数栈中最后的数pop出，就是最后的结果
        int res2 = numStack.pop();
        System.out.printf("表达式%s=%d", expression, res2);
    }
}

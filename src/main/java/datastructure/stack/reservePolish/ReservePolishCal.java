package datastructure.stack.reservePolish;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName algorithm
 * @Author Songleen
 * @Date 2019/08/25/21:16
 *
 * 逆波兰计算器
 */
public class ReservePolishCal {
    public static void main(String[] args) {
        String suffixExpression = "30 4 + 5 * 6 -";
        List<String> list = getListString(suffixExpression);
        int result = calculate(list);
        System.out.println(result);
    }

    //将一个逆波兰表达式放入到arrayList中，省得再去挨着扫描
    public static List<String> getListString(String suffixExpression){
        //将表达式按照空格键分隔
        String[] split = suffixExpression.split(" ");
        List<String> list = new ArrayList<>();
        for (String s : split) {
            list.add(s);
        }
        return list;
    }

    //完成对逆波兰表达式的计算
    public static int calculate(List<String> list){
        Stack<String> stack = new Stack<>();
        for (String item : list) {
            if (item.matches("\\d+")){  //用正则匹配多位数
                stack.push(item);
            }else {
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                if (item.equals("+")){
                    String s = String.valueOf(num1 + num2);
                    stack.push(s);
                }else if (item.equals("-")){
                    String s = String.valueOf(num2 - num1);
                    stack.push(s);
                }else if (item.equals("*")){
                    String s = String.valueOf(num2 * num1);
                    stack.push(s);
                }else if (item.equals("/")){
                    String s = String.valueOf(num2 / num1);
                    stack.push(s);
                }else {
                    throw new RuntimeException("运算符有误");
                }
            }
        }
        int result = Integer.parseInt(stack.pop());
        return result;
    }
}



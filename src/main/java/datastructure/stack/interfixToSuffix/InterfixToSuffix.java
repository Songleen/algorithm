package datastructure.stack.interfixToSuffix;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName algorithm
 * @Author Songleen
 * @Date 2019/08/26/9:05
 * <p>
 * 中缀表达式转后缀表达式
 *
 * 1、准备一个数操作栈s1和符号操作栈s2
 * 2、从左到右遍历表达式
 *  2.1、遇到数字，直接压入数栈
 *  2.2、遇到符号
 *      2.2.1、如果是“（”,则直接压入符号栈
 *      2.2.2、如果是“）”，则依次弹出符号栈，压入数栈，直到遇到“（”，弹出，并舍弃这对括号
 *      2.2.3、其它符号
 *          2.2.3.1、如果符号栈为空，则直接压入符号栈
 *          2.2.3.2、否则，比较符号栈栈顶的符号和当前符号的优先级，如果当前的更高，直接压入符号栈
 *          2.2.3.2、若当前符号的优先级低于等于符号栈栈顶的优先级，则将符号栈顶的运算符弹出并压入到数栈中。再进行2.2.3的步骤。
 */
public class InterfixToSuffix {
    public static void main(String[] args) {
        String interfix2 = "1+ (\n\t(\f\r2.3+3)*4)-5";

        // 去除所有的无用字符
        interfix2 = interfix2.replaceAll("\\s", "");

        List<String> ls = toInfixExpressionList(interfix2);
        System.out.println("中缀表达式对应的List:" + ls);

        List<String> list = parseSuffixExpressionList(ls);
        System.out.println("对应的后缀表达式List:" + list);

    }

    //返回运算符的优先级
    //这里要使用static修饰，才能在上面的main方法中调用
    public static int priority(String item) {
        char oper = item.charAt(0);
        if (oper == '+' || oper == '-') {
            return 1;
        } else if (oper == '*' || oper == '/') {
            return 2;
        } else if (oper == '(' || oper == ')') {
            return 3;
        } else {
            throw new RuntimeException("运算符有误");
        }
    }

    //将一个逆波兰表达式转化成用数组存放
    public static List<String> convert(String operator) {
        String[] split = operator.split(" ");
        List<String> list = new ArrayList<>();
        for (String s : split) {
            list.add(s);
        }
        return list;
    }

    //将中缀表达式转成对应的List， s="1+((2+3)*4)-5,以下这种方式的通用性更好
    public static List<String> toInfixExpressionList(String s) {
        List<String> ls = new ArrayList<>();
        int i = 0;
        String str;
        char c;
        do {

            //如果c是一个非数字，需要加入到ls
            if ((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57) {
                ls.add("" + c);
                i++;

                //如果是一个数，需要考虑多位数
            } else {
                str = "";     //现将str置成""，'0'[48]>'9'[57]
                while (i < s.length() && ((c = s.charAt(i)) >= 48 && (c = s.charAt(i)) <= 57 || (c = s.charAt(i)) == 46)) {  //拼接考虑用while循环
                    str += c; //拼接
                    i++;
                }
                ls.add(str);
            }
        } while (i < s.length());
        return ls;
    }

    //判断时数字还是运算符
    public static boolean isOper(String item) {
        char oper = item.charAt(0);
        if (oper == '+' || oper == '-' || oper == '*' || oper == '/') {
            return true;
        }
        return false;
    }

    //将得到的中缀表达式List ==> 后缀表达式List
    public static List<String> parseSuffixExpressionList(List<String> ls) {
        //定义两个栈,运算符栈s1和中间结果栈s2
        // 因为s2这个栈,在整个转换过程中，没有pop操作，而且后面还需要逆序输出，比较麻烦，所以这里直接使用List<String> s2;
        Stack<String> s1 = new Stack<>();
        // s2是数栈
        List<String> s2 = new ArrayList<>();

        for (String item : ls) {
            //如果是一个数，加入s2
            if (item.matches("([0-9]+\\.[0-9]+)|[0-9]+")) {
                s2.add(item);
            } else if (item.equals("(")) {
                s1.push(item);
            } else if (item.equals(")")) {
                while (s1.size() != 0 && !s1.peek().equals("(")) {
                    s2.add(s1.pop());
                }
                s1.pop();   //将（ 弹栈，消除小括号
            } else {
                //当item的优先级小于等于s1栈顶运算符，将s1栈顶的运算符弹出并加入到s2中，以此循环
                while (s1.size() != 0 && priority(s1.peek()) <= priority(item)) {
                    s2.add(s1.pop());
                }
                //还需将item入栈
                s1.push(item);
            }
        }
        //将s1中剩余的运算符依次弹出并加入s2
        while (s1.size() != 0) {
            s2.add(s1.pop());
        }
        return s2;  //因为是List,因此顺序输出就是对应后缀表达式对应的List；
    }
}

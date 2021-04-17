package datastructure.stack.interfixToPrefix;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName algorithm
 * @Author Songleen
 * @Date 2021/04/17/16:40
 * <p>
 * 中缀表达式转前缀表达式
 * 1、准备两个栈、数栈s1和符号栈s2
 * 2、从右到左遍历表达式
 * 2.1、遇到数字，则直接压入数栈
 * 2.2、遇到符号
 * 2.2.1、如果是“）”或者符号栈为空，则直接入符号栈
 * 2.2.2、若是“（”，则依次将符号栈的元素弹出，压入数栈，直到遇到“）”,舍弃这一对括号
 * 2.2.3、否则比较符号栈栈顶的运算符优先级和当前符号的优先级
 * 2.2.3.1、如果当前符号优先级小于栈顶符号优先级，则直接将符号栈压入符号栈
 * 2.2.3.2、否则弹出符号栈的符号并压入数栈。
 * 2.2.3.3、重复2.2.3的步骤。
 */
public class InterfixToPrefix {
    public static void main(String[] args) {
        String interfix = "1+ (\n\t(\f\r2+3)*4)-5";
        // 去除没用的符号
        interfix = interfix.replaceAll("\\s", "");
        List<String> inertFix = storeWithList(interfix);
        System.out.println(inertFix.toString());
        System.out.println("下面是前缀表达式");

        String prefix = convertInterToPrefix(inertFix);
        System.out.println(prefix);
    }

    /**
     * 将中缀表达式转为前缀表达式
     */
    public static String convertInterToPrefix(List<String> interfix) {
        // 先准备两个栈，因为数栈没有pop操作，这里用array代替
        Stack<String> s1 = new Stack<>();
        List<String> s2 = new ArrayList<>();
        for (int i = interfix.size() - 1; i >= 0; i--) {
            String item = interfix.get(i);
            // 数字直接入栈
            if (item.matches("\\d+\\.\\d+|\\d+")) {
                s2.add(item);
            } else if (item.equals(")")) {
                s1.push(item);
            } else if (item.equals("(")) {
                while (!s1.empty() && !s1.peek().equals(")")) {
                    s2.add(s1.pop());
                }
                s1.pop();
            } else {
                // 比较它和符号栈栈顶的符号的优先级
                while (!s1.isEmpty() && (priority(item) > priority(s1.peek()))) {
                    s2.add(s1.pop());
                }
                // 将item入符号栈
                s1.push(item);
            }
        }

        // 将符号栈的一次压入数栈
        while (!s1.empty()) {
            s2.add(s1.pop());
        }

        return s2.toString();
    }

    /**
     * 将表达式转为String集合存放
     */
    public static List<String> storeWithList(String expression) {
        List<String> arr = new ArrayList<>(expression.length());
        int index = 0;
        String keepNum = "";
        while (index <= expression.length()) {
            char c = expression.charAt(index);
            // 如果是最后一个，则直接添加到集合中
            if (index == expression.length() - 1) {
                arr.add("" + c);
                break;
            }
            // 如果是符号，则直接添加到集合中
            if (c != 46 && (c < 48 || c > 57)) {
                arr.add("" + c);
                index++;
            } else {
                keepNum += c;
                // 下一外是否是数字还是符号
                char nc = expression.charAt(++index);
                if (nc != 46 && (nc < 48 || nc > 57)) {
                    arr.add(keepNum);
                    keepNum = "";
                }
            }
        }
        return arr;
    }

    //判断时数字还是运算符
    public static boolean isOper(String item) {
        char oper = item.charAt(0);
        if (oper == '+' || oper == '-' || oper == '*' || oper == '/') {
            return true;
        }
        return false;
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

}

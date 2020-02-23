package LeetCode.isvalid;

import java.util.Stack;

/**
 * @ClassName algorithm
 * @Author Songleen
 * @Date 2020/02/23/10:53
 */
public class ValidParentheses {
    public static void main(String[] args) {
        String s = "()[]";
        Solution so = new Solution();
        System.out.println(so.isValid(s));

    }
}

class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        if ("".equals(s)) {
            return true;
        }

        Stack<String> stack = new Stack<>();
        stack.push(s.substring(0, 1));

        for (int i = 1; i < s.length(); i++) {
            String next = s.substring(i, i + 1);
            String peek = null;
            if (!stack.empty()) {
                peek = stack.peek();
            }
            if (isMatch(peek, next)) {
                stack.pop();
            } else {
                stack.push(next);
            }
        }
        return stack.empty();
    }

    public boolean isMatch(String s1, String s2) {
        String s = s1 + s2;
        switch (s) {
            case "()":
                return true;
            case "[]":
                return true;
            case "{}":
                return true;
            default:
                return false;
        }
    }


}

package LeetCode.reverse;


/**
 * @ClassName algorithm
 * @Author Songleen
 * @Date 2020/02/22/22:01
 */
public class NumberReverse {
    public static void main(String[] args) {
        Solution s = new Solution();
        int reverse = s.reverse(2147483647);
        System.out.println(reverse);
        System.out.println();
    }
}


class Solution {
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > Integer.MAX_VALUE % 10)) {
                return 0;
            }
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && x < Integer.MIN_VALUE % 10)) {
                return 0;
            }
            rev = rev * 10 + pop;
        }
        return rev;
    }

    public int reverse2(int x) {
        long n = 0;
        while (x != 0) {
            n = n * 10 + x % 10;
            x = x / 10;
        }
        //利用n是否可以强转成功进行判断
        return (int) n == n ? (int) n : 0;
    }
}


package LeetCode.palindrome;

/**
 * 判断一个数是不是回文数
 *
 * @ClassName algorithm
 * @Author Songleen
 * @Date 2020/02/22/23:13
 */
public class IsPalindrome {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isPalindromeNum(121));
    }
}

class Solution {
    public boolean isPalindromeNum(int x) {
        if (x < 0 || x % 10 == 0) {
            return false;
        }
        int rev = 0;
        while (x > rev) {
            int i = x % 10;
            rev = rev * 10 + i;
            x = x / 10;
        }

        //x==rev/10是考虑基数位的情况
        return rev == x || x == rev / 10;
    }
}
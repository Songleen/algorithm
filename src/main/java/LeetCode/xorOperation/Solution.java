package LeetCode.xorOperation;

/**
 * @ClassName algorithm
 * @Author Songleen
 * @Date 2020/07/06/7:28
 */
public class Solution {
    public static void main(String[] args) {
        int result = xorOperation(4, 3);
        System.out.println(result);
    }

    public static int xorOperation(int n, int start) {
        int result = start;
        for (int i = 1; i < n; i++) {
            result ^= (start + 2 * i);
        }
        return result;
    }

}

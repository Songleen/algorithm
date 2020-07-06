package LeetCode.simple;

import java.util.Arrays;

/**
 * 数组的重新排列
 *
 * @ClassName algorithm
 * @Author Songleen
 * @Date 2020/07/06/7:37
 */
public class Shuffle {
    public static void main(String[] args) {
        int[] nums = {2, 5, 1, 3, 4, 7};
        int[] shuffle = shuffle(nums, 3);
        System.out.println(Arrays.toString(shuffle));
    }

    public static int[] shuffle(int[] nums, int n) {
        int[] result = new int[n << 1];
        int index = 0;
        for (int i = 0; i < n; i++) {
            result[index++] = nums[i];
            result[index++] = nums[n + i];
        }
        return result;
    }
}

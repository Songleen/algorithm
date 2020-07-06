package LeetCode.runningsum;

import java.util.Arrays;

/**
 * 数组的动态和
 *
 * @ClassName algorithm
 * @Author Songleen
 * @Date 2020/07/05/22:09
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6};
        // int[] ints = runningSum(nums);
        int[] ints = runningSum2(nums);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] runningSum(int[] nums) {
        int count = 0;
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = 0;
            for (int j = 0; j <= i; j++) {
                count++;
                result[i] += nums[j];
            }
        }
        System.out.println(count);
        return result;
    }

    /**
     * 这个更厉害
     *
     * @param nums
     * @return
     */
    public static int[] runningSum2(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }
}

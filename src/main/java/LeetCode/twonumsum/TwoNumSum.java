package LeetCode.twonumsum;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 求两数之和
 *
 * @ClassName algorithm
 * @Author Songleen
 * @Date 2020/02/22/21:30
 */
public class TwoNumSum {

    /**
     * @Author lisonglin
     * @Date 2020/02/22
     * @Param []
     **/
    @Test
    public void test01() {
        Solution2 s = new Solution2();
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] ints = s.twoSum(arr, 19);
        System.out.println(ints[0] + "---------" + ints[1]);
    }
}

/**
 * 两次哈希表 时间复杂度为O(n)
 *
 * @Author lisonglin
 * @Date 2020/02/22
 * @Param
 **/
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int j = 0; j < nums.length; j++) {
            int annother = target - nums[j];
            if (map.containsKey(annother) && map.get(annother) != j) {
                return new int[]{j, map.get(annother)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}

/**
 * 一遍哈希表 时间复杂度为O(n)
 *
 * @Author lisonglin
 * @Date 2020/02/22
 * @Param
 **/
class Solution2 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}

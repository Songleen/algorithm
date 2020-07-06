package LeetCode.kidsWithCandies;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 拥有最多糖果的孩子
 *
 * @ClassName algorithm
 * @Author Songleen
 * @Date 2020/07/05/22:52
 */
public class Solution {
    public static void main(String[] args) {
        int[] candies = new int[]{2, 3, 5, 1, 3};
        List<Boolean> booleans = kidWithCandies(candies, 3);
        System.out.println(Arrays.asList(booleans));
    }

    public static List<Boolean> kidWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();
        int max = candies[0];
        for (int i = 1; i < candies.length; i++) {
            if (candies[i] > max) {
                max = candies[i];
            }
        }

        for (int i = 0; i < candies.length; i++) {
            if (max <= (candies[i] + extraCandies)) {
                result.add(true);
                continue;
            }
            result.add(false);

        }
        return result;
    }
}

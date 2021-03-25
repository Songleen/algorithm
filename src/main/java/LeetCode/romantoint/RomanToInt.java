package LeetCode.romantoint;

import java.util.HashMap;
import java.util.Map;

/**
 * 罗马数字转整数
 *
 * @ClassName algorithm
 * @Author Songleen
 * @Date 2020/02/23/8:06
 */
public class RomanToInt {
    public static void main(String[] args) {
        Solution2 s = new Solution2();
        int sum = s.romanToInt("MCMXCIV");
        System.out.println(sum);
    }
}

/** 
 *
 * @Author 李松林
 * @Date 2020-09-21 11:57:04
 * @Description
*/
class Solution {
    public int romanToInt(String s) {
        int sum = 0;
        int preNum = getValue(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int num = getValue(s.charAt(i));
            if (preNum < num) {
                sum -= preNum;
            } else {
                sum += preNum;
            }
            preNum = num;
        }
        sum += preNum;
        return sum;
    }

    public int getValue(char ch) {
        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}

/**
 * 将所有情况罗列出来，分别判断
 *
 * @Author lisonglin
 * @Date 2020/02/23
 * @Param
 **/
class Solution2 {
    public int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);

        int sum = 0;
        for (int i = 0; i < s.length(); ) {
            if (i + 1 < s.length() && map.containsKey(s.substring(i, i + 2))) {
                sum += map.get(s.substring(i, i + 2));
                i += 2;
            } else {
                sum += map.get(s.substring(i, i + 1));
                i++;
            }
        }
        return sum;
    }
}



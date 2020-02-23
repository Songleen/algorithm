package LeetCode.longestcommonprefix;

/**
 * @ClassName algorithm
 * @Author Songleen
 * @Date 2020/02/23/9:02
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        Solution s = new Solution();
        String[] arr = {"abdkf", "ab", "abfefadfaef"};
        // String c = s.getCommonPrefix(arr);
        String c = s.longestCommonPrefix3(arr);
        System.out.println(c);
    }
}

class Solution {
    public String getCommonPrefix(String[] s) {
        String shortest = shortestString(s);
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < shortest.length(); i++) {
            String c = shortest.substring(i, i + 1);
            for (int j = 0; j < s.length; j++) {
                String c2 = s[j].substring(i, i + 1);
                if (!c.equals(c2)) {
                    return stringBuffer.toString();
                }
            }
            stringBuffer.append(c);
        }
        return stringBuffer.toString().equals("") ? " " : stringBuffer.toString();
    }

    public String shortestString(String[] s) {
        String first = s[0];
        for (int i = 1; i < s.length; i++) {
            if (first.length() > s[i].length()) {
                first = s[i];
            }
        }
        return first;
    }

    /**
     * 官方解法
     *
     * @Author lisonglin
     * @Date 2020/02/23
     * @Param [strs]
     **/
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }

    /**
     * 官方解法二
     *
     * @Author lisonglin
     * @Date 2020/02/23
     * @Param [strs]
     **/
    public String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    public String longestCommonPrefix3(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String reg = strs[0];
        for (String str : strs) {
            while (!str.startsWith(reg)) {
                if (reg.length() == 1) {
                    return "";
                }
                reg = reg.substring(0, reg.length() - 1);
            }
        }
        return reg;
    }

}

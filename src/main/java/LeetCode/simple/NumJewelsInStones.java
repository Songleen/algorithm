package LeetCode.simple;

/**
 * 石头中的宝石个数
 *
 * @ClassName algorithm
 * @Author Songleen
 * @Date 2020/07/07/17:18
 */
public class NumJewelsInStones {
    public static void main(String[] args) {
        String j = "aA";
        String stone = "aAAbbbb";
        System.out.println(jewelsInStones2(j, stone));
    }

    public static int jewelsInStones(String j, String stone) {
        char[] chars = j.toCharArray();
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            while (stone.indexOf(chars[i]) != -1) {
                stone = stone.replaceFirst(String.valueOf(chars[i]), "1");
                count++;
            }
        }
        return count;
    }

    public static int jewelsInStones2(String j, String stone) {
        byte[] arr = new byte[58];
        int count = 0;

        for (char ch : j.toCharArray()) {
            arr[ch - 65] = 1;
        }

        for (char ch : stone.toCharArray()) {
            if (arr[ch - 65] == 1) {
                count++;
            }
        }

        return count;
    }

}

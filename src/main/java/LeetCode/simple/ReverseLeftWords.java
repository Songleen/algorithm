package LeetCode.simple;

/**
 * 左旋转字符串
 *
 * @ClassName algorithm
 * @Author Songleen
 * @Date 2020/07/06/8:45
 */
public class ReverseLeftWords {
    public static void main(String[] args) {
        System.out.println(reverseLeftWords("abcdefg", 2));
    }

    public static String reverseLeftWords(String s, int n) {
        return s.substring(n) + s.substring(0, n);
    }
}

package LeetCode.simple;

/**
 * @ClassName algorithm
 * @Author Songleen
 * @Date 2020/07/07/18:34
 */
public class SubtractProductAndSum {
    public static void main(String[] args) {
        System.out.println(subtractProductAndSum(234));
    }

    public static int subtractProductAndSum(int n) {
        if (n == 0) {
            return 0;
        }
        int muti = 1;
        int sum = 0;
        while (n != 0) {
            muti *= n % 10;
            sum += n % 10;
            n /= 10;
        }

        return muti - sum;
    }
}

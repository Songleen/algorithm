package LeetCode.simple;

/**
 * 将数字变为0的步骤
 *
 * @ClassName algorithm
 * @Author Songleen
 * @Date 2020/07/07/20:02
 */
public class NumberOfSteps {
    public static void main(String[] args) {
        System.out.println(numberOfSteps(8));
    }

    public static int numberOfSteps(int num) {
        int count = 0;
        while (num != 0) {
            if (num % 2 == 0) {
                num /= 2;
                count++;
            } else {
                num -= 1;
                count++;
            }

        }

        return count;
    }
}

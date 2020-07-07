package LeetCode.simple;

/**
 * 猜数字
 *
 * @ClassName algorithm
 * @Author Songleen
 * @Date 2020/07/06/8:37
 */
public class Game {
    public static void main(String[] args) {
        int[] guess = new int[]{1, 2, 3};
        int[] answer = new int[]{1, 2, 3};
        System.out.println(game(guess, answer));
    }

    public static int game(int[] guess, int[] answer) {
        int count = 0;
        for (int i = 0; i < guess.length; i++) {
            if (guess[i] == answer[i]) {
                count++;
            }
        }
        return count;
    }
}

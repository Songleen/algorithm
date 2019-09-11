package datastructure.recursion;

/**
 * @ClassName algorithm
 * @Author Songleen
 * @Date 2019/08/26/13:52
 */
public class Factorial {
    public static void main(String[] args) {
        /*int res = calFactorial(5);
        System.out.println(res);*/
        print(5);
    }

    //计算某个数的阶乘
    public static int calFactorial(int num) {
        if (num <= 0) {
            throw new RuntimeException("输入的数据不正确，请重新输入");
        }

        //递归出口
        if (num == 1) {
            return 1;
        } else {
            return calFactorial(num - 1) * num;
        }
    }

    //打印问题
    public static void print(int n){
        if (n>2){
            print(n-1);
        }
        //递归出口
        System.out.println("n="+n);
    }
}

package datastructure.search.fibonacci_search;

import java.util.Arrays;

/**
 * @ClassName algorithm
 * @Author Songleen
 * @Date 2019/09/02/14:02
 *
 * 斐波那契查找原理与前两种相似，仅仅改变了中间节点(mid)的位置，mid不再是中间或插值得到，而是位于黄金分割点附近,
 * 即 mid = low + f(k-1)-1 (f代表斐波那契数列)。
 */
public class Fibonacci {
    public static int maxSize = 20;

    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1234};
        int index = fibSearch(arr, 89);

        System.out.println("index=" + index);
    }

    //因为后面mid=low+F(k-1)-1,需要使用到斐波那契数列，因此需要先获取到一个斐波那契数列
    public static int[] fib() {
        int[] f = new int[maxSize];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;
    }

    //编写斐波那契查找算法
    public static int fibSearch(int[] a, int key) {
        int low = 0;
        int high = a.length - 1;
        int k = 0;   //表示斐波那契分割数值的下标
        int mid = 0;    //初始化mid的值

        int[] f = fib();   //获取斐波那契数列 int f[] = fib();

        //获取到斐波那契分割数值的下标，这里就是如果书序列表的长度如果不刚好等于f[k]-1,则增加其长度直到大于或等于f[k]-1
        while (high > f[k] - 1) {
            k++;
        }

        //因为f[k]值可能大于a的长度，因此需要构建一个新的数组temp,不足的部分用0填充
        int[] temp = Arrays.copyOf(a, f[k]);

        //实际上需要使用a数组的最后一个值进行填充
        for (int i = high + 1; i < temp.length; i++) {
            temp[i] = a[high];
        }

        //使用while循环来处理，找到我们的数key,
        while (low <= high) {     //只要这个条件满足，就可以找
            mid = low + f[k - 1] - 1;
            //注意，这里没有使用递归
            if (key < temp[mid]) {     //应该继续向数组的前面查找(左边)
                high = mid - 1;
                k--;
            } else if (key > temp[mid]) {
                low = mid + 1;
                k -= 2;
            } else {     //找到 key = temp[mid]

                //需要确定，返回的是哪个下标
                if (mid <= high) {
                    return mid;
                } else {
                    return high;
                }
            }
        }
        return -1;
    }
}

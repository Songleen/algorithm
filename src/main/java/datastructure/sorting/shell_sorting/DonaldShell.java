package datastructure.sorting.shell_sorting;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @ClassName algorithm
 * @Author Songleen
 * @Date 2019/08/28/18:28
 * <p>
 * 希尔排序：也是一种插入排序，是简单插入排序经过改进之后的一个更高效的版本，也称为缩小增量功能
 * 注意：在用到数组的时候，指针是非常常用的东西，通过指针间接达到了操作数组中的元素的目的
 */
public class DonaldShell {
    public static void main(String[] args) {
        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
//        int[] arr = productArr(80000);

        //排序前的时间
        String before = new SimpleDateFormat("yyyy--MM--dd HH:mm:ss").format(new Date());
        System.out.println("排序之前时间：" + before);

//        shellSortChange(arr);
//        shellSortMove(arr);
        shellSort(arr);

        //排序后的时间
        String after = new SimpleDateFormat("yyyy--MM--dd HH:mm:ss").format(new Date());
        System.out.println("排序之后的时间：" + after);

        System.out.println("希尔排序后：" + Arrays.toString(arr));

    }

    //希尔排序移位法
    public static void shellSortMove(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {

            for (int i = gap; i < arr.length; i++) {
                //给元素找到插入的位置
                int j = i;
                int temp = arr[j];
                while (j - gap >= 0 && temp < arr[j - gap]) {
                    //移动
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                arr[j] = temp;
            }
        }
    }

    //希尔排序交换法
    public static void shellSortChange(int[] arr) {
        //增量gap，逐渐缩小增量
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {

            for (int i = gap; i < arr.length; i++) {

                //遍历各组中的所有元素(共5组，每组2个元素，步长为5)
                //此处的j-=*就是一个指针，将数组的下标往前移动
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[j + gap]) {
                        int temp = 0;               //此处用的交换法
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
        }
    }

    //希尔排序交换法
    public static void shellSort(int[] arr) {

        //第一轮，因为第一轮是将10个数分成了10/2=5组
        for (int i = 5; i < arr.length; i++) {

            //遍历各组中的所有元素(共5组，每组2个元素，步长为5)
            //此处的j-=*就是为了第二次进来的时候推出循环
            for (int j = i - 5; j >= 0; j -= 5) {
                if (arr[j] > arr[j + 5]) {
                    int temp = 0;
                    temp = arr[j];
                    arr[j] = arr[j + 5];
                    arr[j + 5] = temp;
                }
            }

        }
        System.out.println("希尔排序一轮后：" + Arrays.toString(arr));

        //第二轮将10个分为2组
        for (int i = 2; i < arr.length; i++) {
            //遍历各组中的元素，共两组，每组5个，步长为2
            for (int j = i - 2; j >= 0; j -= 2) {
                if (arr[j] > arr[j + 2]) {
                    int temp = 0;
                    temp = arr[j];
                    arr[j] = arr[j + 2];
                    arr[j + 2] = temp;
                }
            }
        }
        System.out.println("希尔排序二轮后：" + Arrays.toString(arr));

        //第三轮将10个分为1组
        for (int i = 1; i < arr.length; i++) {
            //遍历各组中的元素，共1组，10个，步长为1
            for (int j = i - 1; j >= 0; j -= 1) {
                if (arr[j] > arr[j + 1]) {
                    int temp = 0;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println("希尔排序三轮后：" + Arrays.toString(arr));
    }

    //产生一个数组
    public static int[] productArr(int num) {
        //先用数组存放一窜随机数
        int[] arr = new int[num];
        for (int i = 0; i < num; i++) {
            int value = (int) Math.floor(Math.random() * 20);
            arr[i] = value;
        }
        //foreach(arr);
        System.out.println("排序之后……");
        return arr;
    }

    /**
     * 希尔排序交换法
     *
     * @Author lisonglin
     * @Date 2020/02/29
     * @Param []
     **/
    @Test
    public void test2() {
        int[] arr = productArr(10);
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[j + gap]) {
                        int temp = 0;
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
        }
        for (int i : arr) {
            System.out.println(i);
        }
    }
}

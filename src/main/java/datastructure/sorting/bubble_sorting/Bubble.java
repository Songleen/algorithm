package datastructure.sorting.bubble_sorting;

import java.util.Arrays;

/**
 * @ClassName algorithm
 * @Author Songleen
 * @Date 2019/08/27/13:36
 * <p>
 * 通过对排序序列从前向后，依次比较相邻元素的值，若发现逆序，则交换,每排序一次，将本次最大的值放在后面
 * 时间复杂度为O(n^2)，因为有两个for循环
 */
public class Bubble {
    public static void main(String[] args) {
        bubbleSortTemplate();
    }

    private static void bubbleSortTemplate() {
        double[] arr = productArray();

        //然后对数组中的随机数进行冒泡排序
        //对冒泡排序进行优化，如果一次交换都没有发生，则可以提前结束
        boolean flag = false;
        double temp = 0;    //临时变量，做交换时使用
        for (int j = 0; j < arr.length - 1; j++) {

            //内部循环每执行一次，则冒出一个“最大值”放在“最后”
            for (int i = 0; i < arr.length - 1 - j; i++) {
                if (arr[i] > arr[i + 1]) {
                    flag = true;
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
            /*if (!flag) {
                break;
            } else {
                flag = false;
            }*/
            System.out.println("第" + (j + 1) + "趟排序后的数组：");
            System.out.println(Arrays.toString(arr));
        }
        foreach(arr);
    }

    private static double[] productArray() {
        //先用数组存放一窜随机数
        double[] arr = new double[10];
        for (int i = 0; i < 10; i++) {
            double value = Math.floor(Math.random() * 20);
            arr[i] = value;
        }
        foreach(arr);
        System.out.println("排序之后……");
        return arr;
    }

    //遍历数组
    public static void foreach(double[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void bubbleSort(int[] arr) {
        //优化，如果一次都没有交换，就可以提前结束
        int temp = 0;
        boolean flag = false;
        int count = 0;
        for (int j = 0; j < arr.length - 1; j++) {

            for (int i = 0; i < arr.length - 1 - j; i++) {
                if (arr[i] > arr[i + 1]) {
                    flag = true;
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
                count++;
            }
            if (!flag){
                break;
            }else {
                flag = false;
            }
        }
        System.out.println("总共交换了"+count+"次");
    }
}

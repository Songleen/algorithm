package datastructure.sorting.quick_sorting;

import org.junit.Test;

import java.util.Arrays;

/**
 * @ClassName algorithm
 * @Author Songleen
 * @Date 2019/08/29/9:37
 * <p>
 * 快速排序：是对冒泡排序的一种改进。基本思想是：通过一趟排序将要排序的数据分割成独立的两部分，其中一部分的所有数据都要比另一部分的要小，
 * 然后再按此方法对这两部分数据进行快速排序，整个过程可以递归进行，以此达到数据变成有序序列。
 */
public class Quick {
    public static void main(String[] args) {
//        int[] arr = {2, 10, 8, 22, 34, 5, 12, 28, 21, 11};
        int[] arr = {-9, 11, 0, 23, -567, 70, -3, 0};

        test01(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }

    //第一轮
    public static void quickSort(int[] arr, int left, int right) {
        int l = left;   //左下标
        int r = right;  //右下标
        int pivot = arr[(left + right) / 2];    //中轴值
        int temp = 0;   //临时变量，作为交换时用

        while (l < r) {    //循环的目的，让比pivot小的放在左边，大的放在右边

            //当l>=r,说明pivot的左右两的值，已经按照左边全是小于等于pivot，右边全是大于等于pivot的值
            if (l >= r) {
                break;
            }

            while (arr[l] < pivot) {
                l += 1;   //在pivot左边一直找，直到找到的值比pivot大才退出
            }

            while (arr[r] > pivot) {
                r -= 1;   //在pivot左边一直找，直到找到的值比pivot大才退出
            }

            //交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            //如果交换完后，发现这个arr[l] == pivot，r--，前移
            if (arr[l] == pivot) {
                r -= 1;
            }

            //如果交换完后，发现这个arr[r] == pivot，l++，后移
            if (arr[r] == pivot) {
                l += 1;
            }
        }
        //如果l==r,必须l++,r--，否则会出现栈溢出
        if (l == r) {
            l += 1;
            r -= 1;
        }

        //向左递归
        if (left < r) {
            quickSort(arr, left, r);
        }

        //向右递归
        if (right > l) {
            quickSort(arr, l, right);
        }
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
     * 冒泡排序
     *
     * @Author lisonglin
     * @Date 2020/02/29
     * @Param []
     **/
    @Test
    public static void test01(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int pivot = arr[(left + right) / 2];
        int temp = 0;
        while (l < r) {
            if (l >= r) {
                break;
            }
            while (arr[l] < pivot) {
                l += 1;
            }
            while (arr[r] > pivot) {
                r -= 1;
            }

            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            if (arr[l] == pivot) {
                r -= 1;
            }
            if (arr[r] == pivot) {
                l += 1;
            }
        }
        if (l == r) {
            l += 1;
            r -= 1;
        }
        if (left < r) {
            test01(arr, left, r);
        }
        if (l < right) {
            test01(arr, l, right);
        }
        // System.out.println(Arrays.toString(arr));
    }
}

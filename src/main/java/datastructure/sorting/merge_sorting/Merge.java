package datastructure.sorting.merge_sorting;

import java.util.Arrays;

/**
 * @ClassName algorithm
 * @Author Songleen
 * @Date 2019/08/29/13:55
 * <p>
 * 归并排序： 利用归并的思想实现的排序方法，该算法采用经典的分治策略（将问题分成小的问题然后递归求解，而治的阶段则将分的阶段得到的各答案
 * “修补”在一起，实现分而治之）
 * <p>
 * 分的目的就是为了治，合并的次数为n-1次；
 * 归并排序的时间复杂度是比较低的，只有n-1次。
 */
public class Merge {
    public static void main(String[] args) {
        int[] arr = {8, 4, 5, 7, 1, 3, 6, 2};
        int[] temp = new int[arr.length];
        mergeSort(arr, 0, arr.length-1, temp);
        System.out.println(Arrays.toString(arr));
    }

    //分+合的方法
    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;   //中间索引
            //向左递归进行分解
            mergeSort(arr, left, mid, temp);
            //向右递归进行分解
            mergeSort(arr, mid + 1, right, temp);

            //合并
            // merge(arr, left, mid, right, temp);
        }
    }

    /**
     * @Author lisonglin
     * @Date 2020/03/01
     * @Param [arr, 排序的原始数组
     * left, 左边有序序列的初始索引
     * mid, 中间索引
     * right, 右边索引
     * temp,做中转的数组
     * ]
     **/
    //合并的方法
    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;   //初始化i，左边有序序列的初始索引
        int j = mid + 1;  //初始化j，右边有序序列的初始索引
        int t = 0;  //指向temp数组的当前索引

        //先将左右两边(有序)的数据按照规则填充到temp数组，直到左右两边的有序序列，有一边处理完为止
        while (i <= mid && j <= right) {

            //如果左边的有序序列的当前元素，小于等于右边的有序序列的当前元素
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                t += 1;
                i += 1;
            } else {
                temp[t] = arr[j];
                t += 1;
                j += 1;
            }
        }

        //把有剩余数据的一边的数据依次全部填充到temp

        //左边的有序列表还有剩余的数据
        while (i <= mid) {
            temp[t] = arr[i];
            t += 1;
            i += 1;
        }

        //右边的有序列表还有剩余数据
        while (j <= right) {
            temp[t] = arr[j];
            t += 1;
            j += 1;
        }

        //将temp数组的元素拷贝到arr,注意不是每次都拷贝所有，是每合并一次，拷贝一次
        t = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];
            t += 1;
            tempLeft += 1;
        }
    }
}

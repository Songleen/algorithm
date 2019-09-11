package datastructure.sorting.heap_sorting;

import java.util.Arrays;

/**
 * @ClassName algorithm
 * @Author Songleen
 * @Date 2019/09/07/18:16
 * <p>
 * 堆排序的练习
 */
public class Test1 {
    public static void main(String[] args) {
        int[] arr = {4, 6, 8, 5, 9, 13, 12, 65, -1, -99};
        heapSort(arr);
        System.out.print(Arrays.toString(arr));
    }

    /**
     * 堆排序的完整步骤
     */
    public static void heapSort(int[] arr) {
        int temp = 0;

        //第一次调整，注意调整的次数和步长
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }

        //交换,这里的for循环主要是考虑到每次交换后还要重新调整大顶堆
        for (int j = arr.length - 1; j >= 0; j--) {
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, j);
        }
    }

    /**
     * 调整大顶堆的方法
     *
     * @param arr    需要被调整的数组
     * @param i      被调整的非子节点在数组中对应的下标
     * @param length 被调整的完全二叉树的长度
     */
    public static void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++;
            }
            if (arr[k] > temp) {
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }
        arr[i] = temp;
    }
}

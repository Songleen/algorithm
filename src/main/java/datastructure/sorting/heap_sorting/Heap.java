package datastructure.sorting.heap_sorting;

import java.util.Arrays;

/**
 * @ClassName algorithm
 * @Author Songleen
 * @Date 2019/09/04/16:22
 */
public class Heap {
    public static void main(String[] args) {
        int[] arr = {4, 6, 8, 5, 9, 13, 12, 65, -1, -99};
        heapSort(arr);
        System.out.print(Arrays.toString(arr));
    }

    //堆排序实现
    public static void heapSort(int[] arr) {
        int temp = 0;
        System.out.println("堆排序");

        //分步,这里三步走完，只是将一个最大值换到了树顶，还没进行交换
        /*adjustHeap(arr, 3, arr.length);
        System.out.println("第一次"+Arrays.toString(arr));

        adjustHeap(arr, 1, arr.length);
        System.out.println("第二次"+Arrays.toString(arr));

        adjustHeap(arr, 0, arr.length);
        System.out.println("第三次"+Arrays.toString(arr));*/

        //完整代码
        for (int i = arr.length / 2 - 1; i >= 0; i--) {     //这里应该是i--
            adjustHeap(arr, i, arr.length);
        }

        //将堆顶元素与末尾元素进行交换
        for (int j = arr.length - 1; j > 0; j--) {
            //交换
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, j);  //这步非常关键，缺少了自己都感觉程序不对
        }

    }

    /**
     * 将一个数组，调整为一个大顶堆
     * i表示非叶子节点在数组中的索引，以i对应的非叶子节点的树调整为大顶堆
     * length表示对多少个元素继续调整，length是在逐渐减少
     * 最后一个非叶子节点：arr.length/2-1;
     */
    public static void adjustHeap(int[] arr, int i, int length) {
        //调节成为大顶堆
        int temp = arr[i];

        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) { //注意这里不是arr.length
            //如果左子节点比右子节点小,这里的两个顺序不能写反，k+1<length也不能少
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++;
            }

            if (arr[k] > temp) { //如果子节点大于父节点的值
                arr[i] = arr[k];
                i = k;  //i指向k，继续比较
            } else {
                break;
            }
        }
        //当for循环结束后，已经将以i为父节点的树的最大值，放在了顶部(局部)
        arr[i] = temp;
    }
}

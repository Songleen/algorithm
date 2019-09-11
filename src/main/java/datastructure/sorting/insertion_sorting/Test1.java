package datastructure.sorting.insertion_sorting;

import datastructure.sorting.select_sorting.Select;

import java.util.Arrays;

/**
 * @ClassName algorithm
 * @Author Songleen
 * @Date 2019/08/31/17:12
 */
public class Test1 {
    public static void main(String[] args) {
        int[] arr = Select.productArr(10);
        System.out.println(Arrays.toString(arr));
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            int insertVal = arr[i];   //待插入的数
            int insertIndex = i - 1;  //待插入数的前一个数的下标

            //找插入的位置,此处有两个条件，第一个保证数组没有越界，
            //第二个表示当前待插入的值大于它前面的那个值，就是没有找到位置，应该继续循环
            while (insertIndex >= 0 && arr[insertIndex] >= insertVal) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            arr[insertIndex + 1] = insertVal;
        }
    }
}

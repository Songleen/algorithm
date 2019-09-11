package datastructure.search.insertValue_search;

import datastructure.search.binary_search.Binary;

/**
 * @ClassName algorithm
 * @Author Songleen
 * @Date 2019/09/02/10:25
 * <p>
 * 插值查找：其实就是将二分查找中的对半mid，换成另一种求值方式。
 * 目的是为了避免二分查找法中的查找的值刚好是最小值或者最大值的情况。
 */
public class InsertValue {
    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i + 1;
        }

        int index = insertValue(arr, 0, arr.length - 1, 8);
        System.out.println(index);

        int binary = Binary.binary(arr, 8, 0, arr.length - 1);
        System.out.println(binary);
    }


    public static int insertValue(int[] arr, int left, int right, int findVal) {
        System.out.println("插值查找次数~~");

        //注意：findVal<arr[0]和findVal>arr[arr.length-1]必须需要，否则得到的mid可能越界
        if (left > right || findVal < arr[0] || findVal > arr[arr.length - 1]) {
            return -1;
        }

        //求出mid，自适应
        int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);
        int midVal = arr[mid];

        if (findVal > midVal) {
            return insertValue(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) {
            return insertValue(arr, left, mid - 1, findVal);
        } else {
            return mid;
        }
    }
}

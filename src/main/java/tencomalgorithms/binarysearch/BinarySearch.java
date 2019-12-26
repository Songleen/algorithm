package tencomalgorithms.binarysearch;

import org.junit.Test;

/**
 * 二分查找的非递归方式
 *
 * @ClassName algorithm
 * @Author Songleen
 * @Date 2019/12/25/17:15
 */
public class BinarySearch {

    @Test
    public void test1() {
        int[] arr = {1, 3, 5, 7, 13, 45, 56, 100};
        int index = binarySearch(arr, 100);
        System.out.println(index);
    }

    @Test
    public void test2() {
        int[] arr = {1, 3, 5, 7, 13, 45, 56, 100, 111};
        int index = binarySearchRecursion(arr, 138, 0, arr.length - 1);
        System.out.println(index);
    }

    /**
     * 二分查找非递归
     *
     * @param arr    需要查找的数组
     * @param target 要查找的目标数
     * @return 目标数的索引，如果没找到就返回-1
     */
    private int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 二分查找法的递归实现
     *
     * @param arr
     * @param target
     * @param left
     * @param right
     * @return
     */
    private int binarySearchRecursion(int[] arr, int target, int left, int right) {
        int mid = (left + right) / 2;
        if (left > right) {
            return -1;
        }
        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] > target) {
            right = mid - 1;
            return binarySearchRecursion(arr, target, left, right);
        } else {
            left = mid + 1;
            return binarySearchRecursion(arr, target, left, right);
        }
    }
}

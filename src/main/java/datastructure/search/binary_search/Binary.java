package datastructure.search.binary_search;

/**
 * @ClassName algorithm
 * @Author Songleen
 * @Date 2019/09/01/9:47
 */
public class Binary {
    public static void main(String[] args) {
        int[] arr = {0,1,2,3,4,5,6,7,8,9};
        int index = binary(arr, 7, 0, arr.length - 1);
        System.out.println(index);
    }

    //二分查找法
    public static int binary(int[] arr, int findVal, int left, int right) {
        System.out.println("二分查找被调用~~");
        if (left > right) {
            return -1;      //遍历完整个数组也没有找到
        }

        //中轴值对应的下标和中轴值
        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if (findVal > midVal) {  //向右递归
            return binary(arr, findVal, mid + 1, right); //这里mid+1和下面mid-1的不断递归，就可能会满足上面出递归的条件
        } else if (findVal < midVal) {
            return binary(arr, findVal, left, mid - 1);
        }else {
            return mid;     //这里是整个程序的出口
        }
    }
}

package datastructure.search.linear_search;

/**
 * @ClassName algorithm
 * @Author Songleen
 * @Date 2019/09/01/9:17
 *
 * 线性查找算法，就是挨着挨着遍历，找到了就返回下标，没有找打就返回提示
 */
public class Linear {
    public static void main(String[] args) {
        int[] arr = {1,7,6,4,3,9,2,5,8,0};
        int digital = linear(arr, 31);
        System.out.println(digital);
    }

    //线性查找
    public static int linear(int[] arr,int val){
        for (int i = 0; i < arr.length; i++) {
            if (val == arr[i]){
                return i;
            }
        }
        return -1;
    }
}

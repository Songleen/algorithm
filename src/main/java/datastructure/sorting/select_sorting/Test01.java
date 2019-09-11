package datastructure.sorting.select_sorting;

import java.util.Arrays;

/**
 * @ClassName algorithm
 * @Author Songleen
 * @Date 2019/08/31/16:31
 */
public class Test01 {
    public static void main(String[] args) {
        int[] arr = productArr(10);
        System.out.println(Arrays.toString(arr));
//        selectSort(arr);
        selectSort2(arr);
        System.out.println(Arrays.toString(arr));
    }

    //选择排序
    public static void selectSort(int[] arr) {
        //自己实现的方法，感觉更好理解一点，将交换的动作放在了内循环中
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            int minimum = arr[i];   //假定当前值为最小值

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < minimum) {    //当前值不是最小值
                    temp = arr[j];     //和最小值进行交换
                    arr[j] = minimum;
                    minimum = temp;
                }
            }
            //上面的循环出来之后，minimum就是本次循环的最小值
            arr[i] = minimum;
        }
    }

    //视频中的方法
    public static void selectSort2(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minimum = arr[i];   //假定当前值为最小值
            int index = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < minimum) {
                    minimum = arr[j];
                    index = j;
                }
            }

            //退出循环之后，得到的minimum就是最小值，index就是对应的数组下标
            if (index != i) {
                arr[index] = arr[i];
                arr[i] = minimum;
            }
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
}

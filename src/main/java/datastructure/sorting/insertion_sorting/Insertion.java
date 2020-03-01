package datastructure.sorting.insertion_sorting;

import org.junit.Test;

import java.util.Arrays;

/**
 * @ClassName algorithm
 * @Author Songleen
 * @Date 2019/08/28/10:15
 * <p>
 * 插入排序：把n个待排序元素看成为一个有序表和一个无序表，开始时有序表中只包含一个元素，无序表中包含n-1个元素，排序过程中每次从无序表中
 * 取出第一个元素，把它的排序码依次与有序表元素的排序码进行比较，将它插入到适当位置，使之成为新的有序表
 */
public class Insertion {
    public static void main(String[] args) {
//        int[] arr = productArr(80000);
        int[] arr = {34, 101, 33, 12, 22, 6, 5};

//        //排序前的时间
//        String before = new SimpleDateFormat("yyyy--MM--dd HH:mm:ss").format(new Date());
//        System.out.println(before);

        for (int i = 1; i < arr.length; i++) {
            int insertVal = arr[i]; //把要进行插入操作的值先保存起来，以便后面使用
            int insertIndex = i - 1;

            while (insertIndex >= 0 && insertVal <= arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];    //把前面的那个值覆盖正在移动这个，达到了移动的效果
                insertIndex--;
            }

            arr[insertIndex + 1] = insertVal;    //如果第一次没有进入while循环，其实就是将自己赋给自己
        }

        System.out.println(Arrays.toString(arr));

//        //排序后的时间
//        String after = new SimpleDateFormat("yyyy--MM--dd HH:mm:ss").format(new Date());
//        System.out.println(after);

    }

    /**
     * 逐步推导：{101,34,39,1}
     * 第一轮：{101,34,39,1} ==> {34,101,39,1}
     * 将arr[0] = 101,看做是一个有序数组，将后面三个数看作是无序数组，从无序数组中取出第一个数，插入到有序数组中的合适位置
     * 步骤1：定义待插入的数
     * int insertValue = arr[1];
     * int insertIndex = 0;  //即arr[1]前面这个数的下标
     * 步骤2：给insertValue找到插入的位置
     * insertIndex >= 0 保证给insertValue找插入位置，不越界
     * insertValue < arr[insertIndex] 待插入的数，还没有找到插入的位置
     * inertIndex--;   将arr[insertIndex]后移
     * while(insertIndex >= 0 && insertValue <arr[insertIndex]){
     * arr[insertIndex + 1]=arr[insertIndex]
     * insertIndex--;
     * }
     * <p>
     * 当退出while循环时，说明插入的位置已经找到了,insertIndex + 1
     * arr[insertIndex + 1] = insertValue
     * <p>
     * 第二轮：{34,101,39,1} ==> {34,39,101,1}
     * 将arr[0]，arr[1]看做是一个有序数组，将后面三个数看作是无序数组，从无序数组中取出第一个数，插入到有序数组中的合适位置
     * 步骤1：定义待插入的数
     * int insertValue = arr[2];
     * int insertIndex = 1;  //即arr[2]前面这个数的下标
     * 步骤2：给insertValue找到插入的位置
     * insertIndex >= 0 保证给insertValue找插入位置，不越界
     * insertValue < arr[insertIndex] 待插入的数，还没有找到插入的位置
     * inertIndex--;   将arr[insertIndex]后移
     * while(insertIndex >= 0 && insertValue <arr[insertIndex]){
     * arr[insertIndex + 1]=arr[insertIndex]
     * insertIndex--;
     * }
     * <p>
     * 当退出while循环时，,说明插入的位置已经找到了,insertIndex + 1
     * arr[insertIndex + 1] = insertValue
     */

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

    //遍历数组
    public static void foreach(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    @Test
    public void test01() {
        int[] arr = productArr(10);
        for (int i = 1; i < arr.length; i++) {
            int insertValue = arr[i];
            int insertIndex = i - 1;
            while (insertIndex < arr.length && arr[insertIndex] < insertValue) {
                insertValue = arr[insertIndex];
                insertIndex--;
            }
            arr[insertIndex] = insertValue;
        }
        foreach(arr);
    }

    /**
     * @Author lisonglin
     * @Date 2020/02/29
     * @Param []
     **/
    @Test
    public void test02() {
        int[] arr = productArr(20);
        for (int i = 1; i < arr.length; i++) {
            int insertValue = arr[i];
            int insertIndex = i - 1;
            while (insertIndex >= 0 && insertValue < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            arr[insertIndex + 1] = insertValue;
        }

        foreach(arr);
    }
}

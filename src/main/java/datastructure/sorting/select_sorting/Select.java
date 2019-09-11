package datastructure.sorting.select_sorting;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @ClassName algorithm
 * @Author Songleen
 * @Date 2019/08/27/15:19
 * <p>
 * 选择排序：从欲排序的数据中，按指定的规则选出某一元素，再依照规定交换位置后达到排序的目的。
 * <p>
 * 它的基本思想是：第一次从arr[0]~arr[n-1]中选取最小值，与arr[0]交换，
 * 第二次从arr[1]~arr[n-1]中选取最小值，与arr[1]交换，第三次从arr[2]~arr[n-1]中选取最小值，与arr[2]交换，…，
 * 第i次从arr[i-1]~arr[n-1]中选取最小值，与arr[i-1]交换，…,
 * 第n-1次从arr[n-2]~arr[n-1]中选取最小值，与arr[n-2]交换，总共通过n-1次，得到一个按排序码从小到大排列的有序序列。
 */
public class Select {
    public static void main(String[] args) {
        //获取数组
        int[] arr = productArr(80000);

        //排序前的时间
        String before = new SimpleDateFormat("yyyy--MM--dd HH:mm:ss").format(new Date());
        System.out.println(before);

        //进行选择排序
        for (int i = 0; i < arr.length - 1; i++) {
            int minimum = arr[i];   //先假定当前的值为最小值
            int index = i;      //当前的下标

            for (int j = i + 1; j < arr.length; j++) {
                if (minimum > arr[j]) {    //当前的值不是最小值
                    minimum = arr[j];
                    //这个地方其实是为下面的数据交换做准备，注意看，minimum=arr[j];arr[index]=arr[i];arr[i]=minimum
                    //三个式子刚好是一个交换的环
                    index = j;  //经过一番查找，找到了最小值对应的索引
                }
            }

            //将最小值放在arr[i]中，即交换
            if (index != i) {
                arr[index] = arr[i];
                arr[i] = minimum;
            }

            //System.out.println("第"+(i+1)+"轮后：");
            //System.out.println(Arrays.toString(arr));
        }

        System.out.println("选择排序后的结果……");
        //foreach(arr);
        String after = new SimpleDateFormat("yyyy--MM--dd HH:mm:ss").format(new Date());
        System.out.println(after);
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

    //遍历数组
    public static void foreach(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }


}

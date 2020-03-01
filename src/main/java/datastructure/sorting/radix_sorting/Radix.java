package datastructure.sorting.radix_sorting;

import org.junit.Test;

import java.util.Arrays;

/**
 * @ClassName algorithm
 * @Author Songleen
 * @Date 2019/08/30/16:09
 * <p>
 * 基数排序(稳定的排序法)：属于分配式排序，又叫桶子法，它就是通过键值的各个位的值，将要排序的元素分配到某些桶中，达到排序的目的
 * <p>
 * 外面的桶有10个，分别代表0-9，这10个桶可以用一个数组来表示，数组长度为10；
 * 上面的每个桶中又会放多个数据，这也可以用一个数组来表示，数组的长度是需要被排序的数组的长度(因为考虑最极端的情况：即所有数据都放在同一个桶中);
 * <p>
 * 基数排序是空间换时间的经典算法
 * <p>
 * 有负数的数组在排序时，会得到结果为负数的桶，因此会出现数组越界，如果需要参考视屏中链接。
 */
public class Radix {
    public static void main(String[] args) {
        int[] arr = {53, 3, 542, 743, 14, 214};
        radis(arr);
    }

    public static void radis(int[] arr) {
        //求得数组中最大数的位数
        Integer maxLength = getMaxLength(arr);

        //声明一个二维数组和一个用来记录内桶存放元素个数的一维数组
        int[][] bucket = new int[10][arr.length];
        int[] bucketCounts = new int[10];

        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            //放入元素到二维数组中
            for (int j = 0; j < arr.length; j++) {
                int unit = arr[j] / n % 10;
                bucket[unit][bucketCounts[unit]] = arr[j];
                bucketCounts[unit]++;
            }

            //从二维数组中取出元素放回到原数组中
            int index = 0;
            for (int k = 0; k < bucketCounts.length; k++) {
                if (bucketCounts[k] != 0) {
                    for (int m = 0; m < bucketCounts[k]; m++) {
                        arr[index] = bucket[k][m];
                        index++;
                    }
                }
                bucketCounts[k] = 0;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    //基数排序
    public static void steps(int[] arr) {
        //第一轮
        //用一个二维数组来装数据
        int[][] bucket = new int[10][arr.length];

        //桶内的数组，用来记录各个桶中放入的数据个数，如inner[0]就是指temp[0]中放入数据的个数
        int[] bucketElementCounts = new int[10];

        //将arr按个位数来排序
        for (int i = 0; i < arr.length; i++) {
            int unit = arr[i] % 10; //获取对应的个位数

            //放入到对应的桶中
            bucket[unit][bucketElementCounts[unit]] = arr[i];
            bucketElementCounts[unit]++;
        }

        int index = 0;
        //按照这个桶的顺序(一维数组的下标依次取出数据，放入原来的数组)

        for (int j = 0; j < bucket.length; j++) {
            if (bucketElementCounts[j] != 0) {

                for (int k = 0; k < bucketElementCounts[j]; k++) {

                    arr[index] = bucket[j][k];
                    index++;
                }
            }
            bucketElementCounts[j] = 0; //第一轮处理后，将bucketElementCounts[k] = 0;
        }
        System.out.println("第一轮，对个位的排序处理：" + Arrays.toString(arr));

        //第二轮
        //将arr按十位数来排序
        for (int i = 0; i < arr.length; i++) {
            int unit = arr[i] / 10 % 10; //获取对应的十位数

            //放入到对应的桶中
            bucket[unit][bucketElementCounts[unit]] = arr[i];
            bucketElementCounts[unit]++;
        }

        int index2 = 0;
        //按照这个桶的顺序(一维数组的下标依次取出数据，放入原来的数组)
        for (int j = 0; j < bucket.length; j++) {
            if (bucketElementCounts[j] != 0) {

                for (int k = 0; k < bucketElementCounts[j]; k++) {

                    arr[index2] = bucket[j][k];
                    index2++;
                }
            }
            bucketElementCounts[j] = 0;
        }
        System.out.println("第二轮，对个位的排序处理：" + Arrays.toString(arr));

        //第三轮
        //将arr按百位数来排序
        for (int i = 0; i < arr.length; i++) {
            int unit = arr[i] / 100 % 10; //获取对应的百位数

            //放入到对应的桶中
            bucket[unit][bucketElementCounts[unit]] = arr[i];
            bucketElementCounts[unit]++;
        }

        int index3 = 0;
        //按照这个桶的顺序(一维数组的下标依次取出数据，放入原来的数组)
        for (int j = 0; j < bucket.length; j++) {
            if (bucketElementCounts[j] != 0) {

                for (int k = 0; k < bucketElementCounts[j]; k++) {

                    arr[index3] = bucket[j][k];
                    index3++;
                }
            }
        }
        System.out.println("第三轮，对个位的排序处理：" + Arrays.toString(arr));
    }

    public static Integer getMaxLength(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return String.valueOf(max).length();
    }

    @Test
    public void test02() {
        int[] arr = {53, 3, 7, -2, 3, -4, 5, 6};
        Integer maxLength = getMaxLength(arr);

        int[][] bucket = new int[10][arr.length];
        int[] bucketCounts = new int[10];   //用来保存内桶中存放元素的个数

        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {

            for (int j = 0; j < arr.length; j++) {
                //将数组中元素放入桶中
                int unit = arr[j] / n % 10;
                bucket[unit][bucketCounts[unit]] = arr[j];
                bucketCounts[unit]++;
            }

            int index = 0;
            //从桶中取出元素放回数组中
            for (int j = 0; j < bucket.length; j++) {
                if (bucketCounts[j] != 0) {
                    for (int k = 0; k < bucketCounts[j]; k++) {
                        arr[index] = bucket[j][k];
                        index++;
                    }
                    bucketCounts[j] = 0;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }


    @Test
    public void test03() {
        int[] arr = {53, 3, 0, -8, 90};
        int maxLength = getMaxLength(arr);

        int[][] bucket = new int[10][arr.length];
        int[] bucketCounts = new int[10];

        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {

            for (int j = 0; j < arr.length; j++) {
                int unit = arr[j] / n % 10;
                bucket[unit][bucketCounts[unit]] = arr[j];
                bucketCounts[unit]++;
            }

            int index = 0;
            for (int k = 0; k < bucket.length; k++) {
                if (bucketCounts[k] != 0) {
                    for (int m = 0; m < bucketCounts[k]; m++) {
                        arr[index] = bucket[k][m];
                        index++;
                    }
                    bucketCounts[k] = 0;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}

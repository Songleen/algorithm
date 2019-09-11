package datastructure.search.binary_search;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName algorithm
 * @Author Songleen
 * @Date 2019/09/02/9:04
 * <p>
 * 当一个有序列表中有相同的数值时，如何将所有的值都返回？
 * 解决方法：在找到mid索引的时候，不要立刻返回，向mid左边和右边索引扫描，将所有满足的元素的下标，加入到集合中
 */
public class Binary2 {
    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1000, 1234};
        List<Integer> indexs = binarySearch2(arr, 0, arr.length - 1, 1000);
        System.out.println(indexs);
    }

    //二分查找算法，找多个相同值的索引
    public static List<Integer> binarySearch2(int[] arr, int left, int right, int findVal) {
        System.out.println("使用二分查找法~~");

        //如果没有找到
        if (left > right) {
            return new ArrayList<Integer>();
        }

        int mid = (left + right) / 2;
        int midVal = arr[mid];

        //此处不要马上返回，分别向mid索引值的左边和右边扫描，将所有满足的元素下标，加入到集合中
        List<Integer> resIndexList = new ArrayList<>();

        if (findVal > midVal) {
            return binarySearch2(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) {
            return binarySearch2(arr, left, mid - 1, findVal);
        } else {

            //向mid索引值左边扫描
            int temp = mid - 1;
            while (true) {
                if (temp < 0 || arr[temp] != findVal) {
                    break;
                }
                //否则，将temp放入到集合中
                resIndexList.add(temp);
                temp -= 1;
            }

            //向mid右边扫描,将所有满足的元素下标，加入到集合中
            temp = mid + 1;
            while (true) {
                if (temp > arr.length - 1 || arr[temp] != findVal) {
                    break;
                }

                //否则，将temp放入到集合中
                resIndexList.add(temp);
                temp += 1;
            }
            resIndexList.add(mid);
            return resIndexList;
        }
    }
}

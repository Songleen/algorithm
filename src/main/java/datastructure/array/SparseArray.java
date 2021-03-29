package datastructure.array;

import org.junit.Test;

/**
 * @ClassName algorithm
 * @Author Songleen
 * @Date 2019/08/02/21:02
 */
public class SparseArray {

    @Test
    public void test() {
        int arr1[][] = new int[11][11];
        arr1[1][2] = 1;
        arr1[2][3] = 2;
        arr1[4][5] = 2;
        int count = 0;
        for (int[] ints : arr1) {
            for (int anInt : ints) {
                System.out.printf("%d\t", anInt);  //d标识输出十进制整数
                if (anInt != 0) {
                    count++;
                }
            }
            System.out.println();
        }

        //创建稀疏数组，数组要比元素组的元素数量多一个
        int[][] spareArr = new int[count + 1][3];

        //给稀疏数组赋值
        spareArr[0][0] = 11;
        spareArr[0][1] = 11;
        spareArr[0][2] = count;

        //遍历二维数组，将非零的值放进去 sum是记录第几个非零数据
        int sum = 0;
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1.length; j++) {
                if (arr1[i][j] != 0) {
                    sum++;
                    spareArr[sum][0] = i;
                    spareArr[sum][1] = j;
                    spareArr[sum][2] = arr1[i][j];
                }
            }
        }

        //输出稀疏数组
        System.out.println("稀疏数组的形式为：");
        for (int i = 0; i < spareArr.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n", spareArr[i][0], spareArr[i][1], spareArr[i][2]);
        }

        //将稀疏数组转化为原始的二维数组
        System.out.println("将稀疏数组转化为原来的二维数组");
        int row = spareArr[0][0];
        int col = spareArr[0][1];

        //原始二维数组的框架
        int[][] arr3 = new int[row][col];

        for (int i = 1; i < spareArr.length; i++) {
            arr3[spareArr[i][0]][spareArr[i][1]] = spareArr[i][2];
        }

        System.out.println("再次遍历原始二维数组：");
        printArr(arr3);
    }

    // 以下是第二次练习
    @Test
    public void test02() {
        // 定义一个原始的二维数组，并往里面添加三个元素
        int[][] arr = new int[8][8];
        arr[1][2] = 3;
        arr[2][3] = 4;
        arr[4][5] = 5;
        // 打印原始的二维数组，记录其中非零的元素个数
        int count = 0;
        for (int[] ints : arr) {
            for (int anInt : ints) {
                if (anInt != 0) {
                    count++;
                }
                System.out.printf("%d\t", anInt);
            }
            System.out.println();
        }

        // 定义一个稀疏数组，它的列数是固定的，3列。行数是原始二维数组元素个数加1,
        int[][] sparseArr = new int[count + 1][3];
        // 给稀疏数组赋初始值
        sparseArr[0][0] = arr.length;
        sparseArr[0][1] = arr[0].length;
        sparseArr[0][2] = count;

        // 将原始数组转为稀疏数组,这里需要一个标记来记录是第几个非零数字,
        // 它就是稀疏数组的行号
        int no = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] != 0) {
                    no++;
                    sparseArr[no][0] = i;
                    sparseArr[no][1] = j;
                    sparseArr[no][2] = arr[i][j];
                }
            }
        }

        System.out.println("以下是遍历稀疏数组---------------");
        // 遍历稀疏数组
        printArr(sparseArr);

        // 将稀疏数组转换为原始数组
        int rowNum = sparseArr[0][0];
        int columnNum = sparseArr[0][1];
        int[][] originalArr = new int[rowNum][columnNum];
        for (int i = 1; i < sparseArr.length; i++) {
            originalArr[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }

        System.out.println("以下是遍历原始数组…………");
        // 遍历原始数组
        printArr(originalArr);
    }

    // 二维数组的遍历
    private void printArr(int[][] arr) {
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.printf("%d\t", anInt);
            }
            System.out.println();
        }
    }
}

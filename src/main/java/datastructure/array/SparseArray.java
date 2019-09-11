package datastructure.array;

import org.junit.Test;

/**
 * @ClassName algorithm
 * @Author Songleen
 * @Date 2019/08/02/21:02
 */
public class SparseArray {

    @Test
    public void test(){
        int arr1[][]= new int[11][11];
        arr1[1][2] = 1;
        arr1[2][3] = 2;
        arr1[4][5] = 2;
        int count = 0;
        for (int[] ints : arr1) {
            for (int anInt : ints) {
                System.out.printf("%d\t",anInt);  //d标识输出十进制整数
                if (anInt != 0){
                    count++;
                }
            }
            System.out.println();
        }

        //创建稀疏数组
        int[][] spareArr = new int[count+1][3];

        //给稀疏数组赋值
        spareArr[0][0] = 11;
        spareArr[0][1] = 11;
        spareArr[0][2] = count;

        //遍历二维数组，将非零的值放进去 sum是记录第几个非零数据
        int sum = 0;
        for (int i=0;i<arr1.length;i++){
            for (int j=0;j<arr1.length;j++){
                if (arr1[i][j] != 0){
                    sum++;
                    spareArr[sum][0] = i;
                    spareArr[sum][1] = j;
                    spareArr[sum][2] = arr1[i][j];
                }
            }
        }

        //输出稀疏数组
        System.out.println("稀疏数组的形式为：");
        for (int i=0;i<spareArr.length;i++){
            System.out.printf("%d\t%d\t%d\t\n",spareArr[i][0],spareArr[i][1],spareArr[i][2]);
        }

        //将稀疏数组转化为原始的二维数组
        System.out.println("将稀疏数组转化为原来的二维数组");
        int row = spareArr[0][0];
        int col = spareArr[0][1];

        //原始二维数组的框架
        int[][] arr3 = new int[row][col];

        for (int i=1;i<spareArr.length;i++){
            arr3[spareArr[i][0]][spareArr[i][1]]=spareArr[i][2];
        }

        System.out.println("再次遍历原始二维数组：");
        for (int[] ints : arr3) {
            for (int an : ints) {
                System.out.printf("%d\t",an);
            }
            System.out.println();
        }
    }
}

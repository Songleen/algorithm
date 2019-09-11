package datastructure.recursion.eightQueens;

/**
 * @ClassName algorithm
 * @Author Songleen
 * @Date 2019/08/26/19:36
 * <p>
 * 每摆一个子，则此子所在的行、列和斜线都不能再摆子
 *
 * 从问题的某一种可能出发, 搜索从这种情况出发所能达到的所有可能, 当这一条路走到” 尽头 “的时候, 再倒回出发点,
 * 从另一个可能出发, 继续搜索. 这种不断” 回溯 “寻找解的方法, 称作” 回溯法 “。
 */
public class EightQueens {
    //定义一个max表示共有多少个皇后
    int max = 8;

    //定义数组array，保存皇后放置位置的结果，比如arr={0,4,7,5,2,6,1,3}，数组元素的下标与行数相同，（值+1）表示第几列(这点非常重要)，
    //例如arr[0]=0 表示第一个皇后放在第一列第一行(皇后作为数组的下标)，arr[1]=4表示第二个皇后放在第二列第5行……
    int[] array = new int[max];
    static int count = 0;

    public static void main(String[] args) {
        EightQueens queens = new EightQueens();
        queens.check(0);
        System.out.printf("一共有%d种解法：",count);
    }

    //编写一个方法，放置第n个皇后
    //注意：check是每一次递归时，进入到check中都会有for(int i=0;i<max;i++),因此会回溯
    public void check(int n) {
        if (n == 8) {  //n==8，表示8个皇后已经放好
            print();
            return;
        }

        //依次放入，并判断是否冲突
        for (int i = 0; i < max; i++) {
            array[n] = i;   //将当前的皇后n，放在第n行的第1列
            if (judge(n)){
                //如果返回true,则表示不冲突,接着放n+1个皇后,即开始递归
                check(n+1);
            }
            //如果冲突，就继续执行for循环，即将第n个皇后，放置在本行的后移一个位置
        }
    }


    //查看放置第n个皇后，检查该皇后是否和前面已经摆放的皇后冲突，true表示不冲突
    //array[i] == array[n] 表示判断第n个皇后是否和前面n-1个皇后在同一列
    //Math.abs(n - i) == Math.abs(array[n] - array[i])表示判断第n个皇后是否和第i个皇后在同一斜线上面
    private boolean judge(int n) {
        for (int i = 0; i < n; i++) {   //i表示第几个皇后，因为需要和前面已经放置的皇后都进行一次判断，所以使用for循环,注意n==0时，表示第一个皇后
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }

    //打印八个皇后的方法
    public void print() {
        count++;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}


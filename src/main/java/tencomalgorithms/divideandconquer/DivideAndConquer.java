package tencomalgorithms.divideandconquer;

import org.junit.Test;

/**
 * @ClassName algorithm
 * @Author Songleen
 * @Date 2019/12/25/18:45
 */
public class DivideAndConquer {

    @Test
    public void test1() {
        int num = 6;
        hanoiTower(num, 'A', 'B', 'C');
    }

    /**
     * @param num 盘的个数
     * @param a   杆a
     * @param b   杆b
     * @param c   杆c
     */
    private void hanoiTower(int num, char a, char b, char c) {
        if (num == 1) {
            System.out.println("第1个盘从" + a + "->" + c);
        } else {
            //如果有多个盘，总是可以看作两个盘:1-最下面的盘,2-上面所有盘
            //1、将上面所有盘移动到a->b,移动过程会用到c
            hanoiTower(num - 1, a, c, b);
            //2、将最下面的盘移动到c
            System.out.println("第" + num + "盘从" + a + "->" + c);
            //3、把b上所有盘(不管有几个，先看成整体)从b->c,移动过程会用到a
            hanoiTower(num - 1, b, a, c);
        }
    }
}

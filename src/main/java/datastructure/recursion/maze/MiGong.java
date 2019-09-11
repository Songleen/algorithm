package datastructure.recursion.maze;

/**
 * @ClassName algorithm
 * @Author Songleen
 * @Date 2019/08/26/17:45
 */
public class MiGong {
    public static void main(String[] args) {
        //先创建一个二维数组来模拟迷宫
        int[][] map = new int[8][7];

        //值为1的地方设为墙,将第一行和最后一行都设置为墙
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }

        //将第一列和最后一列都设置为墙
        for (int j = 0; j < 8; j++) {
            map[j][0] = 1;
            map[j][6] = 1;
        }

        //将第四行第二、三列设置为墙
        map[3][1] = 1;
        map[3][2] = 1;

        //显示地图样式
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(" " + map[i][j]);
            }
            System.out.println();
        }

        System.out.println("=========显示走过了路径=========");
        setWay(map, 1, 1);
        int count = 0;
        //显示地图样式
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 2) {
                    count++;
                }
                System.out.print(" " + map[i][j]);
            }
            System.out.println();
        }
        System.out.println(count);
    }

    /**
     * 使用递归回溯来给小球找路
     * 几点说明:
     * 1、map表示地图
     * 2、i、j表示从地图的那个地方出发
     * 3、如果小球能到map[6][5]的位置，则说明通路找到
     * 4、约定：map[i][j]为0表示该点没有走过，1表示墙，2表示通路可以走，3表示该点已经走过，但走不通
     * 5、确定一个策略: 下->右->上->左
     */
    public static boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) {  //通路已经找到
            return true;
        } else {
            if (map[i][j] == 0) { //当前这个点还没有走过
                map[i][j] = 2;   //假定该点是可以走通，但是能不能走通还不知道
                if (setWay(map, i + 1, j)) {   //向下走
                    return true;
                } else if (setWay(map, i, j + 1)) { //向右走
                    return true;
                } else if (setWay(map, i - 1, j)) { //向上走
                    return true;
                } else if (setWay(map, i, j - 1)) { //向左走
                    return true;
                } else {
                    //说明该点是走不通的
                    map[i][j] = 3;
                    return false;
                }
            } else { //如果map[i][j]!=0，可能是1,2,3
                return false;
            }
        }
    }

}

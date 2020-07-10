package tencomalgorithms.board;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 马踏棋盘算法
 *
 * @ClassName algorithm
 * @Author Songleen
 * @Date 2020/07/09/11:17
 */
public class HorseWalkChesses {
    public static void main(String[] args) {
        int x = 5;
        int y = 5;
        Chessboard cb = new Chessboard(x, y);
        int row = 1;
        int column = 1;
        int[][] chessboard = new int[x][y];
        cb.traversalChessBorad(chessboard, row - 1, column - 1, 1);

        for (int[] rows : chessboard) {
            for (int step : rows) {
                System.out.print(step + "\t");
            }
            System.out.println();
        }
    }
}

class Chessboard {
    int x;  // 棋盘的列数
    int y;  // 棋盘的行数
    boolean[] visited; // 标记棋盘的各个位置是否被访问过,不是用的二维数组，而是数学位置
    boolean finished; // 表示是否棋盘的所有位置都被访问过

    public Chessboard(int x, int y) {
        this.x = x;
        this.y = y;
        visited = new boolean[x * y];
    }

    /**
     * @Author lisonglin
     * @Date 2020/07/09
     * @Param [chessboard, row(马儿当前所在行), column(马儿当前所在列), step(第几步)]
     **/
    public void traversalChessBorad(int[][] chessboard, int row, int column, int step) {
        chessboard[row][column] = step;
        // 标记已经被访问过
        visited[row * x + column] = true;
        List<Point> nextList = next(new Point(column, row));
        while (!nextList.isEmpty()) {
            Point point = nextList.remove(0);
            // 判断该点是否已访问过
            if (!visited[point.y * x + point.x]) {
                traversalChessBorad(chessboard, point.y, point.x, step + 1);
            }
        }

        // 判断是否已完成任务，如果没有，将棋盘置0
        if (step < x * y && !finished) {
            chessboard[row][column] = 0;
            visited[row * x + column] = false;
        } else {
            finished = true;
        }
    }

    // 获取当前位置可移动的位置
    public List<Point> next(Point curPoint) {
        List<Point> ps = new ArrayList<>();
        Point p = new Point();
        // 判断马儿可以走0
        if ((p.x = curPoint.x + 2) < x && (p.y = curPoint.y - 1) >= 0) {
            ps.add(new Point(p.x, p.y));
        }
        // 判断马儿可以走1
        if ((p.x = curPoint.x + 2) < x && (p.y = curPoint.y + 1) < y) {
            ps.add(new Point(p.x, p.y));
        }
        // 马儿可以走2
        if ((p.x = curPoint.x + 1) < x && (p.y = curPoint.y + 2) < y) {
            ps.add(new Point(p.x, p.y));
        }
        // 马儿可以走3
        if ((p.x = curPoint.x - 1) >= 0 && (p.y = curPoint.y + 2) < y) {
            ps.add(new Point(p.x, p.y));
        }
        // 马儿可以走4
        if ((p.y = curPoint.y + 1) < y && (p.x = curPoint.x - 2) > x) {
            ps.add(new Point(p.x, p.y));
        }
        // 判断马儿可以走5的位置
        if ((p.y = curPoint.y - 1) >= 0 && (p.x = curPoint.x - 2) >= 0) {
            ps.add(new Point(p.x, p.y));
        }
        // 判断马儿可以走6
        if ((p.y = curPoint.y - 2) >= 0 && (p.x = curPoint.x - 1) >= 0) {
            ps.add(new Point(p.x, p.y));
        }
        // 判断马儿可以走7
        if ((p.y = curPoint.y - 2) >= 0 && (p.x = curPoint.x + 1) < x) {
            ps.add(new Point(p.x, p.y));
        }

        return ps;
    }
}

package tencomalgorithms.kruskal;

import java.util.Arrays;

/**
 * 克鲁斯卡尔算法
 *
 * @ClassName algorithm
 * @Author Songleen
 * @Date 2020/07/08/9:14
 */
public class KruskalCase {
    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        char[] vertexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int matrix[][] = {
                {0, 12, INF, INF, INF, 16, 14},
                {12, 0, 10, INF, INF, 7, INF},
                {INF, 10, 0, 3, 5, 6, INF},
                {INF, INF, 3, 0, 4, INF, INF},
                {INF, INF, 5, 4, 0, 2, 8},
                {16, 7, 6, INF, 2, 0, 9},
                {14, INF, INF, INF, 8, 9, 0}
        };
        Graph graph = new Graph(vertexs, matrix);

        graph.kruskal();

    }
}


class Graph {
    // 用INF表示两个顶点不连通
    private static final int INF = Integer.MAX_VALUE;
    // 边的条数
    private int edgeNum;
    // 顶点数组
    private char[] vertexes;
    // 临接矩阵
    private int[][] matrix;

    public Graph(char[] vertexes, int[][] matrix) {
        int vlen = vertexes.length;
        // 初始化顶点
        this.vertexes = new char[vertexes.length];
        for (int i = 0; i < vertexes.length; i++) {
            this.vertexes[i] = vertexes[i];
        }

        // 初始化边,并统计边的个数
        this.matrix = new int[vlen][vlen];
        for (int i = 0; i < vlen; i++) {
            for (int j = 0; j < vlen; j++) {
                this.matrix[i][j] = matrix[i][j];

            }
        }

        // 统计边的条数
        for (int i = 0; i < vlen; i++) {
            for (int j = i + 1; j < vlen; j++) {
                if (matrix[i][j] != Integer.MAX_VALUE) {
                    this.edgeNum++;
                }
            }
        }
    }

    public int getEdgeNum() {
        return edgeNum;
    }

    // 克鲁斯卡尔算法
    public void kruskal() {
        int index = 0;
        int[] ends = new int[edgeNum];
        EData[] rets = new EData[edgeNum];
        EData[] edges = getEdges();
        sortEdges(edges);
        for (int i = 0; i < edgeNum; i++) {
            int p1 = getPosition(edges[i].start);
            int p2 = getPosition(edges[i].end);
            int m = getEnd(ends, p1);
            int n = getEnd(ends, p2);
            if (m != n) {
                // 这里只需要标记终点就行
                ends[m] = n;
                // 将边添加到结果中
                rets[index++] = edges[i];
            }
        }
        System.out.println("最小生成树为：" + Arrays.toString(rets));
    }

    // 打印临接矩阵
    public void showMatrix(Graph graph) {
        int[][] matrix = graph.matrix;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%15d\t", matrix[i][j]);
            }
            System.out.println();
        }
    }

    // 对边根据权值进行冒泡排序
    public void sortEdges(EData[] edges) {
        for (int i = 0; i < edges.length - 1; i++) {
            for (int j = 0; j < edges.length - 1 - i; j++) {
                if (edges[j].weight > edges[j + 1].weight) {
                    EData temp = edges[j + 1];
                    edges[j + 1] = edges[j];
                    edges[j] = temp;
                }
            }
        }
    }

    // 获取顶点的值
    private char getPosition(int num) {
        for (int i = 0; i < vertexes.length; i++) {
            if (num == i) {
                return vertexes[i];
            }
        }
        return '1';
    }


    // 获取图中的边
    public EData[] getEdges() {
        int index = 0;
        EData[] eDatas = new EData[getEdgeNum()];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[i].length; j++) {
                if (matrix[i][j] != Integer.MAX_VALUE) {
                    EData eData = new EData(vertexes[i], vertexes[j], matrix[i][j]);
                    eDatas[index] = eData;
                    index++;
                }
            }
        }
        return eDatas;
    }

    // 获取顶点对应的下标
    private int getPosition(char ch) {
        for (int i = 0; i < vertexes.length; i++) {
            if (vertexes[i] == ch) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 获取下标为i的顶点的终点，用于后面判断两个顶点的终点是否相同
     *
     * @param i 表示传入的顶点对应的下标
     * @return 返回的就是小标为i的这个顶点对应的终点的小标
     * @Param ends 记录各个顶点对应的终点是哪个，ends在数组遍历过程中，逐步形成
     * @Author lisonglin
     * @Date 2020/07/08
     **/
    private int getEnd(int[] ends, int i) {
        // 这里其实就是在找终点，用的是字符对应的下标表示
        while (ends[i] != 0) {
            i = ends[i];
        }
        return i;
    }

}


class EData {

    char start; // 边的起点
    char end;   // 边的终点
    int weight; // 边的权重

    public EData(char start, char end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "EData{" +
                "start=" + start +
                ", end=" + end +
                ", weight=" + weight +
                '}';
    }
}


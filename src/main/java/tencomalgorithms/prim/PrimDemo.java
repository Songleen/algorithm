package tencomalgorithms.prim;

import java.util.Arrays;

/**
 * @ClassName algorithm
 * @Author Songleen
 * @Date 2020/07/05/17:12
 */
public class PrimDemo {
    public static void main(String[] args) {
        char[] data = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int nodes = data.length;
        MGraph mGraph = new MGraph(nodes);
        int[][] weight = new int[][]{
                {1000, 5, 7, 1000, 1000, 1000, 2},
                {5, 1000, 1000, 9, 1000, 1000, 3},
                {7, 1000, 1000, 1000, 8, 1000, 1000},
                {1000, 9, 1000, 1000, 1000, 4, 1000},
                {1000, 1000, 8, 1000, 1000, 5, 4},
                {1000, 1000, 1000, 4, 5, 1000, 6},
                {2, 3, 1000, 1000, 4, 6, 1000},
        };
        minTree minTree = new minTree();
        minTree.createGraph(mGraph, nodes, data, weight);
        // minTree.showGraph(mGraph);
        minTree.prim(mGraph, 0);
    }

}

// 创建最小说生成树
class minTree {

    /**
     * @Author lisonglin
     * @Date 2020/07/05
     * @Param [graph图对象, nodes图的顶点个数, data图各个顶点的值, weight图的临接矩阵]
     **/
    public void createGraph(MGraph graph, int nodes, char data[], int[][] weight) {
        int i, j;

        // 把传进来的数据放到图的节点上
        for (i = 0; i < nodes; i++) {
            graph.data[i] = data[i];
            for (j = 0; j < nodes; j++) {
                graph.weight[i][j] = weight[i][j];
            }
        }
    }

    // 显示图的临接矩阵,就是遍历二维数组
    public void showGraph(MGraph mGraph) {
        for (int i = 0; i < mGraph.weight.length; i++) {
            System.out.println(Arrays.toString(mGraph.weight[i]));
        }
    }

    /**
     * prim算法
     *
     * @param mGraph
     * @param v      表示从哪个顶点开始
     */
    public void prim(MGraph mGraph, int v) {

        // 标记节点是否已经被访问过，默认值都是0，表示没有被访问过
        int visited[] = new int[mGraph.nodes];

        // 将当前节点标记为已访问
        visited[v] = 1;

        // h1和h2记录两个顶点的下标
        int h1 = -1, h2 = -1;
        int minWeight = 1000;

        // 因为有mGraph.nodex节点，prim算法结束后，有mGraph.nodes - 1条边,每一次找到一条边,并对minWeight做赋值
        for (int k = 1; k < mGraph.nodes; k++) {

            // 这里面是将当前节点和其它节点（包括自己）挨着匹配了一次
            for (int i = 0; i < mGraph.nodes; i++) {
                for (int j = 0; j < mGraph.nodes; j++) {
                    if (visited[i] == 1 && visited[j] == 0 && mGraph.weight[i][j] < minWeight) {
                        minWeight = mGraph.weight[i][j];
                        h1 = i;
                        h2 = j;
                    }
                }
            }

            System.out.println("边<" + mGraph.data[h1] + "," + mGraph.data[h2] + "> 权值：" + minWeight);
            visited[h2] = 1;
            minWeight = 1000;
        }
    }
}


// 图类
class MGraph {
    // 图的节点总个数
    int nodes;
    // 节点的数据
    char[] data;
    // 存放临接矩阵的二维数组
    int[][] weight;

    // 初始化图的属性，比如节点总数
    public MGraph(int nodes) {
        this.nodes = nodes;
        data = new char[nodes];

        // 这里用二维数组来模拟图，用二维数组的节点值表示它们是否连通，比如1000表示没有连通。
        weight = new int[nodes][nodes];
    }
}
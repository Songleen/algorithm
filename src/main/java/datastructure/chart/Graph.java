package datastructure.chart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName algorithm
 * @Author Songleen
 * @Date 2019/12/21/11:09
 */
public class Graph {
    /**
     * 存储顶点集合
     */
    private List<String> vertexes;

    /**
     * 存储边的数目
     */
    private int numOfEdges;

    /**
     * 存储图对应的邻接矩阵,就是顶点之间的路径
     */
    private int[][] edges;
    private boolean[] isVisited;

    public Graph(int n) {
        this.vertexes = new ArrayList<>(n);
        this.edges = new int[n][n];
        this.numOfEdges = 0;
        this.isVisited = new boolean[5];
    }

    /**
     * 插入顶点
     *
     * @param vertex 顶点值
     */
    public void insertVertex(String vertex) {
        vertexes.add(vertex);
    }

    /**
     * 插入边
     *
     * @param v1     顶点1对应的下标
     * @param v2     顶点2对应的下标
     * @param weight 表示关联
     */
    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }

    /**
     * 返回边条数
     */
    public int getNumOfEdges() {
        return vertexes.size();
    }

    /**
     * 返回节点个数
     */
    public int getNumOfVertex() {
        return numOfEdges;
    }

    /**
     * 返回下标i对应的数据
     */
    public String getValueByIndex(int i) {
        return vertexes.get(i);
    }

    /**
     * 返回v1,v2的权值
     */
    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }

    /**
     * 显示图对应的矩阵
     */
    public void showGraph() {
        for (int i = 0; i < edges.length; i++) {
            for (int j = 0; j < edges[i].length; j++) {
                System.out.print(edges[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void showGraph2() {
        for (int[] edge : edges) {
            System.out.println(Arrays.toString(edge));
        }
    }

    /**
     * 得到第一个邻接节点的下标
     *
     * @param index 本节点的下标
     * @return 若存在则返回对应的下标，否则返回-1
     */
    public int getFirstNeighbor(int index) {
        for (int i = 0; i < vertexes.size(); i++) {
            if (edges[index][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 根据前一个邻接节点的下标来获取下一个邻接节点
     *
     * @param v1
     * @param v2
     * @return
     */
    public int getNextVertex(int v1, int v2) {
        for (int i = v2 + 1; i < vertexes.size(); i++) {
            if (edges[v1][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 深度优先遍历算法
     * i：第一次就是0
     */
    private void dfs(boolean[] isVisited, int i) {
        System.out.print(getValueByIndex(i) + "->");
        isVisited[i] = true;
        //查找节点i的第一个邻接节点w
        int w = getFirstNeighbor(i);
        while (w != -1) {
            if (!isVisited[w]) {
                dfs(isVisited, w);
            }

            //如果w已经被访问过
            w = getNextVertex(i, w);
        }
    }

    /**
     * 对dfs进行一个重载，遍历多有的节点，并进行dfs
     */
    public void dfs() {
        //遍历所有的节点，进行dfs[回溯]
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]) {
                dfs(isVisited, i);
            }
        }
    }
}

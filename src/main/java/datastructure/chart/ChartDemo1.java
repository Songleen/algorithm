package datastructure.chart;

import org.junit.Test;

/**
 * @ClassName algorithm
 * @Author Songleen
 * @Date 2019/12/21/10:17
 */
public class ChartDemo1 {

    @Test
    public void test1() {
        Graph graph = new Graph(5);

        //循环添加节点
        String[] vertexes = {"A", "B", "C", "D", "E"};
        for (String vertex : vertexes) {
            graph.insertVertex(vertex);
        }

        //添加边 A-B A-C B-C B-D B-E
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 2, 1);
        graph.insertEdge(0, 4, 1);

        graph.showGraph();
        graph.showGraph2();
        System.out.println("深度遍历");
        graph.dfs();
    }
}

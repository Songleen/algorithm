package datastructure.tree.application.huffmanTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName algorithm
 * @Author Songleen
 * @Date 2019/09/08/16:54
 */
public class BuildHuffmanTree {
    public static void main(String[] args) {
        int[] arr = {13, 7, 8, 3, 29, 6, 1};
        System.out.println("霍夫曼树：");
        Node node = buildHuffman(arr);
        node.preOrder();
    }

    /**
     * 创建霍夫曼树的方法
     *
     * @param arr 被用于创建霍夫曼树的数组
     * @return Node 霍夫曼树的根节点,可用于遍历检查是否是正确的
     */
    public static Node buildHuffman(int[] arr) {
        //1、遍历数组，将arr中每一个元素构建成一个Node,并将node放入到arrList中
        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            Node node = new Node(arr[i]);
            nodes.add(node);
        }

        //只要节点数大于1，就循环构建
        while (nodes.size() > 1) {
            //排序，从小到大
            Collections.sort(nodes);

            //取出最小的两个
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);

            //创建一个新的节点
            Node newNode = new Node(leftNode.getValue() + rightNode.getValue());

            //设置节点关系
            newNode.setLeft(leftNode);
            newNode.setRight(rightNode);
            nodes.add(newNode);

            //最后别忘了删除已经被使用过的节点
            nodes.remove(leftNode);
            nodes.remove(rightNode);
        }

        //最后只剩一个节点
        return nodes.get(0);
    }
}

package datastructure.tree.application.huffmanCoding;

/**
 * @ClassName algorithm
 * @Author Songleen
 * @Date 2019/09/09/13:48
 */
public class Node implements Comparable<Node> {
    private String data;
    private int count;
    private Node leftNode;
    private Node rightNode;

    public Node(String data, int count) {
        this.data = data;
        this.count = count;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data='" + data + '\'' +
                ", count=" + count +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        return this.count - o.count;
    }

    //编写一个前序遍历方法
    public void preOrder() {
        System.out.println(this);
        if (this.leftNode != null) {
            this.leftNode.preOrder();
        }
        if (this.rightNode != null) {
            this.rightNode.preOrder();
        }
    }
}

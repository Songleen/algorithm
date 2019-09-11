package datastructure.tree.application.huffmanTree;

/**
 * @ClassName algorithm
 * @Author Songleen
 * @Date 2019/09/08/16:47
 * <p>
 * 节点,让其实现Comparable接口，以便使用Collections集合排序
 */
public class Node implements Comparable<Node> {
    private int value;  //节点权值
    private Node left;
    private Node right;

    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public int compareTo(Node o) {
        //如果是减，就是从小到大排列
        return this.value - o.value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    //编写一个前序遍历
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.getLeft().preOrder();
        }
        if (this.right != null) {
            this.getRight().preOrder();
        }
    }
}

package datastructure.tree.threadedbinarytree;

import org.junit.Test;

/**
 * @ClassName algorithm
 * @Author Songleen
 * @Date 2020/02/03/15:02
 */
public class ThreadedDemo {

    @Test
    public void test1() {
        RoleNode root = new RoleNode(1, "tom");
        RoleNode node2 = new RoleNode(3, "jack");
        RoleNode node3 = new RoleNode(6, "smith");
        RoleNode node4 = new RoleNode(8, "mary");
        RoleNode node5 = new RoleNode(10, "king");
        RoleNode node6 = new RoleNode(14, "dim");

        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);

        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree(root);
        threadedBinaryTree.threadedNodes();
        System.out.println("10号节点的前驱节点是=" + node5.getLeft());
        System.out.println("10号节点的后继节点是=" + node5.getRight());
    }
}

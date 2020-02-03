package datastructure.tree.threadedbinarytree;

/**
 * @ClassName algorithm
 * @Author Songleen
 * @Date 2020/02/03/14:10
 */
public class ThreadedBinaryTree {
    private RoleNode root;
    /**
     * 为进行线索化，需创建指向当前节点的前驱节点的指针
     * 在递归进行线索化时，pre总是保留前一个节点
     */
    private RoleNode pre = null;

    public ThreadedBinaryTree(RoleNode root) {
        this.root = root;
    }

    public void threadedNodes() {
        this.threadedNodes(root);
    }

    /**
     * 线索化方法
     */
    public void threadedNodes(RoleNode node) {
        //如果node为空，不能进行线索化
        if (node == null) {
            return;
        }

        //线索化左子树
        threadedNodes(node.getLeft());

        //线索化当前节点
        //处理当前节点的前驱节点
        if (node.getLeft() == null) {
            node.setLeft(pre);
            node.setLeftType(1);
        }
        //处理当前节点的后继节点
        if (pre != null && pre.getRight() == null) {
            pre.setRight(node);
            pre.setRightType(1);
        }
        //每处理一个节点后，让当前节点是下一个节点的前驱节点
        pre = node;

        //线索化右子树
        threadedNodes(node.getRight());
    }

    /**
     * 遍历线索化二叉树的方法
     */
    public void threadedList() {
        //定义一个变量，存储当前遍历的节点，从root开始
        RoleNode node = root;
        while (node != null) {
            //循环找到leftType == 1的节点，因为当leftType ==1时，说明该节点是线索化过的
            while (node.getLeftType() == 0) {
                node = node.getLeft();
            }
            System.out.println(node);

            //如果当前节点的右指针指向的是后继节点，就一直输出
            while (node.getRightType() == 1) {
                node = node.getRight();
                System.out.println(node);
            }

            //替换这个遍历的节点
            node = node.getRight();
        }
    }
}

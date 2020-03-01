package datastructure.tree.binarysorttree;

/**
 * @ClassName algorithm
 * @Author Songleen
 * @Date 2020/03/01/20:07
 */
public class TreeNode {
    private int value;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    //添加节点
    public void add(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.getValue() < this.value) {
            if (this.left == null) {
                this.left = node;
                return;
            }
            this.left.add(node);
            return;
        } else {
            if (this.right == null) {
                this.right = node;
                return;
            }
            this.right.add(node);
            return;
        }
    }

    //中序遍历二叉排序树
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }

        System.out.print(this.getValue() + " ");

        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    //查找节点
    public TreeNode search(int value) {
        if (value == this.value) {
            return this;
        } else if (value < this.value) {
            if (this.left == null) {
                return null;
            }
            return this.left.search(value);
        } else {
            if (this.right == null) {
                return null;
            }
            return this.right.search(value);
        }
    }

    //查找要删除节点的父节点
    public TreeNode searchParent(int value) {
        if ((this.left != null && value == this.left.value) ||
                (this.right != null && value == this.right.value)) {
            return this;
        } else if (value < this.value) {
            if (this.left == null) {
                return null;
            }
            return this.left.searchParent(value);
        } else {
            if (this.right == null) {
                return null;
            }
            return this.right.searchParent(value);
        }
    }

}

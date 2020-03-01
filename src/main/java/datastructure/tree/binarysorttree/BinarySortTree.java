package datastructure.tree.binarysorttree;

/**
 * @ClassName algorithm
 * @Author Songleen
 * @Date 2020/03/01/21:14
 */
public class BinarySortTree {
    private TreeNode root;

    public TreeNode getRoot() {
        return root;
    }

    //添加节点
    public void add(TreeNode node) {
        if (root == null) {
            root = node;
            return;
        }
        root.add(node);
    }


    //查找要删除的节点
    public TreeNode search(int value) {
        if (root == null) {
            return null;
        }
        return root.search(value);
    }

    //查找父节点
    public TreeNode searchParent(int value) {
        if (root == null) {
            return null;
        }
        return root.searchParent(value);
    }

    //中序遍历
    public void infixOrder() {
        root.infixOrder();
    }

    //删除节点
    public void delNode(int value) {
        if (root == null) {
            return;
        }
        TreeNode targetNode = search(value);
        if (targetNode == null || targetNode.getValue() == root.getValue()) {
            return;
        }
        TreeNode parent = searchParent(value);
        if (targetNode.getLeft() == null && targetNode.getRight() == null) {
            if (parent.getRight().getValue() == targetNode.getValue()) {
                parent.setRight(null);
            } else {
                parent.setLeft(null);
            }
        } else if (targetNode.getLeft() != null && targetNode.getRight() != null) {
            TreeNode right = targetNode.getRight();
            while (right.getLeft() != null) {
                right = right.getLeft();
            }
            int temp = right.getValue();
            TreeNode rightParent = searchParent(right.getValue());
            rightParent.setRight(null);
            targetNode.setValue(temp);
        } else {
            if (targetNode.getLeft() != null) {
                if (parent.getLeft().getValue() == targetNode.getValue()) {
                    parent.setLeft(targetNode.getLeft());
                }
                if (parent.getRight().getValue() == targetNode.getValue()) {
                    parent.setRight(targetNode.getLeft());
                }
            } else {
                if (parent.getLeft().getValue() == targetNode.getValue()) {
                    parent.setLeft(targetNode.getRight());
                }
                if (parent.getRight().getValue() == targetNode.getValue()) {
                    parent.setRight(targetNode.getRight());
                }
            }
        }
    }
}

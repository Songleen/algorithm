package datastructure.tree.binarysorttree;

/**
 * @ClassName algorithm
 * @Author Songleen
 * @Date 2020/03/01/20:09
 */
public class BinarySortTreeDemo {
    public static void main(String[] args) {
        int[] arr = {7, 3, 10, 12, 5, 1, 9, 2, 11, 6};
        BinarySortTree sortTree = new BinarySortTree();
        for (int i = 0; i < arr.length; i++) {
            sortTree.add(new TreeNode(arr[i]));
        }

        //中序遍历二排序树
        sortTree.infixOrder();

        //删除叶子节点
        sortTree.delNode(12);

        System.out.println();
        sortTree.infixOrder();

    }
}

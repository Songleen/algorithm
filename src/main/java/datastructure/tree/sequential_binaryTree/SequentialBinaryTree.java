package datastructure.tree.sequential_binaryTree;

/**
 * @ClassName algorithm
 * @Author Songleen
 * @Date 2019/09/03/10:45
 */
public class SequentialBinaryTree {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        System.out.println("前序遍历:");
        arrBinaryTree.preOrder();
        System.out.println();
        System.out.println("中序遍历:");
        arrBinaryTree.infixOrder();
        System.out.println("后序遍历:");
        arrBinaryTree.afterOrder();
    }
}

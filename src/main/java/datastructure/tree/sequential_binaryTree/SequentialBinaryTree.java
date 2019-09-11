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
        arrBinaryTree.preOrder();
        System.out.println("中序遍历:");
        arrBinaryTree.infixOrder();
    }
}
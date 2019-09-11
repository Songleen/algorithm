package datastructure.tree.sequential_binaryTree;

/**
 * @ClassName algorithm
 * @Author Songleen
 * @Date 2019/09/03/13:41
 * <p>
 * 顺序存储二叉树遍历
 */
public class ArrBinaryTree {
    private int[] arr;  //存储数据节点的数组

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    //编写方法，完成顺序存储二叉树的前序遍历
    public void preOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空");
            return;
        }

        System.out.print(arr[index] + " ");

        //向左递归遍历
        if (index * 2 + 1 < arr.length) {
            preOrder(2 * index + 1);
        }

        //向右递归遍历
        if (index * 2 + 2 < arr.length) {
            preOrder(index * 2 + 2);
        }
    }

    //重载preOrder
    public void preOrder() {
        this.preOrder(0);
    }

    public void infixOrder(){
        this.infixOrder(0);
    }

    //顺序存储二叉树的中序遍历
    public void infixOrder(int index){
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空");
            return;
        }

        //向左递归遍历
        if (index * 2 + 1 < arr.length) {
            infixOrder(2 * index + 1);
        }

        System.out.print(arr[index] + " ");

        //向右递归遍历
        if (index * 2 + 2 < arr.length) {
            infixOrder(index * 2 + 2);
        }

    }
}

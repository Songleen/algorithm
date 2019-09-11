package datastructure.tree.binaryTree;

/**
 * @ClassName algorithm
 * @Author Songleen
 * @Date 2019/09/03/8:51
 */
public class BinaryTree {
    private HeroNode root;

    public BinaryTree(HeroNode root) {
        this.root = root;
    }

    //前序遍历
    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    //中序遍历
    public void infixOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    //后序遍历
    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    //前序查找
    public HeroNode preSearch(int no){
        return this.root.preSearch(no);
    }

    //中序查找
    public HeroNode infixSearch(int no){
        return this.root.infixSearch(no);
    }

    //后序查找
    public HeroNode postSearch(int no){
        return this.root.postSearch(no);
    }

    //删除指定节点
    public void deleteNode(int no){
        if (this.root == null){
            System.out.println("树是空的，无法删除");
            return;
        }

        this.root.delete(no);
        this.root.preOrder();
    }
}

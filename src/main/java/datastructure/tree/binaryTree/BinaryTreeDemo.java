package datastructure.tree.binaryTree;

/**
 * @ClassName algorithm
 * @Author Songleen
 * @Date 2019/09/03/8:56
 */
public class BinaryTreeDemo {
    public static void main(String[] args) {
//        HeroNode root = new HeroNode(0, "0");
        HeroNode node1 = new HeroNode(1, "1");
        HeroNode node2 = new HeroNode(2, "2");
        HeroNode node3 = new HeroNode(3, "3");
        HeroNode node4 = new HeroNode(4, "4");
        HeroNode node5 = new HeroNode(5, "5");
        HeroNode node6 = new HeroNode(6, "6");
        HeroNode node7 = new HeroNode(7, "7");

        node1.setLeft(node2);
        node1.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);
        node3.setRight(node7);

        BinaryTree tree = new BinaryTree(node1);
        System.out.println("前序遍历");
        tree.preOrder();
        System.out.println("中序遍历");
        tree.infixOrder();
        System.out.println("后序遍历");
        tree.postOrder();

        System.out.println("前序查找");
        HeroNode heroNode = tree.preSearch(3);
        System.out.println(heroNode);

        System.out.println("中序查找");
        HeroNode heroNode1 = tree.infixSearch(3);
        System.out.println(heroNode1);

        System.out.println("后序查找");
        HeroNode heroNode2 = tree.postSearch(3);
        System.out.println(heroNode2);

        System.out.println("删除指定节点");
        tree.deleteNode(3);
    }
}

package datastructure.tree.binaryTree;

/**
 * @ClassName algorithm
 * @Author Songleen
 * @Date 2019/09/03/8:43
 */
public class HeroNode {
    private int no;
    private String name;
    private HeroNode left;  //默认null
    private HeroNode right; //默认null

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    //前序遍历
    public void preOrder() {
        System.out.println(this);   //输出父节点

        if (this.left != null) {
            this.getLeft().preOrder();  //递归左边节点
        }
        if (this.right != null) {
            this.getRight().preOrder(); //递归右边节点
        }
    }

    //中序遍历
    public void infixOrder() {
        if (this.left != null) {
            this.getLeft().infixOrder();  //递归左边节点
        }

        System.out.println(this);   //输出父节点

        if (this.right != null) {
            this.getRight().infixOrder(); //递归右边节点
        }
    }

    //后序遍历
    public void postOrder() {
        if (this.left != null) {
            this.getLeft().postOrder();  //递归左边节点
        }

        if (this.right != null) {
            this.getRight().postOrder(); //递归右边节点
        }

        System.out.println(this);   //输出父节点
    }

    //前序查找
    public HeroNode preSearch(int no) {
        System.out.println("开始前序查找");

        if (this.getNo() == no) {
            return this;
        }

        HeroNode node = null;
        if (this.left != null) {
            node = this.left.preSearch(no);
        }
        if (node != null) {
            return node;
        }

        if (this.right != null) {
            node = this.right.preSearch(no);
        }
        return node;
    }

    //中序查找
    public HeroNode infixSearch(int no) {
        System.out.println("开始中序查找");

        HeroNode node = null;
        if (this.left != null) {
            node = this.left.infixSearch(no);
        }
        if (node != null) {
            return node;
        }

        if (this.getNo() == no) {
            return this;
        }

        if (this.right != null) {
            node = this.right.infixSearch(no);
        }
        return node;
    }

    //后序查找
    public HeroNode postSearch(int no) {
        System.out.println("开始后序查找");

        HeroNode node = null;
        if (this.left != null) {
            node = this.left.postSearch(no);
        }
        if (node != null) {
            return node;
        }

        if (this.right != null) {
            node = this.right.postSearch(no);
        }
        if (node != null) {
            return node;
        }

        if (this.getNo() == no) {
            return this;
        }

        return null;
    }

    //删除节点，如果是叶子节点，则直接删除，如果是非叶子节点，则直接删除整棵树
    public void delete(int no) {

        if (this.left != null && this.left.getNo() == no) {
            this.left = null;
            return;
        }
        if (this.right != null && this.right.getNo() == no) {
            this.right = null;
            return;
        }
        if (this.left != null) {
            this.left.delete(no);
        }
        if (this.right != null) {
            this.right.delete(no);
        }
    }


}

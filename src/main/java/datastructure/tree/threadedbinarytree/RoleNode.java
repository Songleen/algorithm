package datastructure.tree.threadedbinarytree;

/**
 * 线索化二叉树
 *
 * @ClassName algorithm
 * @Author Songleen
 * @Date 2020/02/03/11:46
 */
public class RoleNode {
    private int no;
    private String name;
    private RoleNode left;
    private RoleNode right;
    /**
     * 为0表示指向的是左子树，为1表示指向前驱节点
     */
    private int leftType;
    /**
     * 为0表示指向的是右子树，为1表示指向后继节点
     */
    private int rightType;

    public RoleNode(int no, String name) {
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

    public RoleNode getLeft() {
        return left;
    }

    public void setLeft(RoleNode left) {
        this.left = left;
    }

    public RoleNode getRight() {
        return right;
    }

    public void setRight(RoleNode right) {
        this.right = right;
    }

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    @Override
    public String toString() {
        return "RoleNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    /**
     * 前序遍历
     */
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    /**
     * 中序遍历
     */
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    /**
     * 后序遍历
     */
    public void postOrder() {
        if (this.left != null) {
            this.left.postOrder();
        }
        if (this.right != null) {

            this.right.postOrder();
        }
        System.out.println(this);
    }

    /**
     * 前序遍历查找
     */
    public RoleNode preOrderSearch(int no) {
        System.out.println("进入前序遍历");
        if (this.no == no) {
            return this;
        }

        RoleNode resNode = null;
        if (this.left != null) {
            resNode = this.left.preOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }

        if (this.right != null) {
            resNode = this.right.preOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        return resNode;
    }

    /**
     * 中序遍历查找
     */
    public RoleNode infixOrderSearch(int no) {
        System.out.println("进入中序遍历");
        RoleNode resNode = null;
        if (this.left != null) {
            resNode = this.left.preOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }

        if (this.no == no) {
            return this;
        }

        if (this.right != null) {
            resNode = this.right.preOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        return resNode;
    }

    /**
     * 后序遍历查找
     */
    public RoleNode postOrderSearch(int no) {
        System.out.println("进入后序遍历");
        RoleNode resNode = null;
        if (this.left != null) {
            resNode = this.left.preOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }

        if (this.right != null) {
            resNode = this.right.preOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }

        if (this.no == no) {
            return this;
        }
        return resNode;
    }

    /**
     * 递归删除节点
     * 1、如果删除的是叶子节点，则删除该节点
     * 2、如果删除的是非叶子节点，则删除该子树
     */
    public void delNode(int no) {
        if (this.left != null && this.left.getNo() == no) {
            this.left = null;
            return;
        }
        if (this.right != null && this.right.getNo() == no) {
            this.right = null;
            return;
        }

        //向左子树递归删除
        if (this.left != null) {
            this.left.delNode(no);
        }

        //向右子树递归删除
        if (this.right != null) {
            this.right.delNode(no);
        }
    }
}

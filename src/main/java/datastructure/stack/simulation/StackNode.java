package datastructure.stack.simulation;

/**
 * @ClassName algorithm
 * @Author Songleen
 * @Date 2019/08/25/11:17
 * <p>
 * 单向链表节点
 */
public class StackNode {
    private int no;
    private StackNode next;

    public StackNode(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }


    public StackNode getNext() {
        return next;
    }

    public void setNext(StackNode next) {
        this.next = next;
    }
}

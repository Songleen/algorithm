package datastructure.stack.simulation;

/**
 * @ClassName algorithm
 * @Author Songleen
 * @Date 2019/08/25/11:15
 * <p>
 * 使用单向链表来模拟栈
 */
public class LinkedStack {
    private StackNode head = new StackNode(0);  //头节点

    //添加元素到链表
    public void add(StackNode node) {
        StackNode temp = head;
        while (true) {
            if (temp.getNext() == null) {
                break;
            }
            temp = temp.getNext();
        }
        temp.setNext(node);
    }

    //反转链表
    public static void reserveLink(StackNode head) {
        if (head == null || head.getNext().getNext() == null) {
            System.out.println("这是一个空链表，怎么反转？");
            return;
        }

        StackNode cur = head.getNext();
        StackNode next = null;
        StackNode reserveHead = new StackNode(0);

        while (cur != null){
            //下面几步的步骤不可更改
            next = cur.getNext();   //将cur往后推
            cur.setNext(reserveHead.getNext());
            reserveHead.setNext(cur);
            cur = next;
        }
        head.setNext(reserveHead.getNext());
    }
}

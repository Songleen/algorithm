package datastructure.doubleLinkedList;

/**
 * @ClassName algorithm
 * @Author Songleen
 * @Date 2019/08/24/17:56
 */
public class DoubleLinkedList {
    private HeroNode2 head = new HeroNode2(0, "", "");

    public HeroNode2 getHead() { //获取头节点
        return head;
    }

    //遍历双向链表
    public void list() {
        if (head == null) {
            System.out.println("是空链表，无法遍历");
            return;
        }

        HeroNode2 temp = head.getNext();
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);   //输出节点的信息
            temp = temp.getNext();
        }
    }

    //添加一个节点到双向链表的最后
    public void add(HeroNode2 node) {
        if (node == null) {
            System.out.println("节点为空");
            return;
        }
        HeroNode2 temp = head;
        while (true) {
            if (temp.getNext() == null) {
                break;
            }
            temp = temp.getNext();
        }
        temp.setNext(node);
        node.setPre(temp);  //双向链表
    }

    //修改一个节点的内容,和单向链表一样
    public void update(int no, HeroNode2 node) {
        if (head.getNext() == null) {
            System.out.println("链表为空");
            return;
        }

        HeroNode2 temp = head.getNext();
        while (true) {
            if (temp == null) {
                System.out.printf("没有找到编号%d的节点，不能修改", no);
                break;
            }
            if (temp.getNo() == no) {
                temp.setName(node.getName());
                temp.setNickname(node.getNickname());
                break;
            }
            temp = temp.getNext();
        }
    }

    //从双向链表中删除一个节点
    public void delete(int no) {
        if (head.getNext() == null) {
            System.out.println("链表为空");
            return;
        }

        HeroNode2 temp = head.getNext();
        while (true) {
            if (temp == null) {
                System.out.println("没有对应编号的节点");
                return;
            }
            if (temp.getNo() == no && temp.getNext() != null) {
                HeroNode2 preNode = temp.getPre();  //上一个节点
                HeroNode2 nextNode = temp.getNext();   //下一个节点
                preNode.setNext(nextNode);
                nextNode.setPre(preNode);
                break;
            }
            temp = temp.getNext();
        }
    }

    //获取链表的有效元素个数
    public static int getLength(HeroNode2 node){
        if (node == null){
            throw new RuntimeException("链表为空链表");
        }
        int count = 0;
        while (true){
            if (node.getNext()!= null){
                count++;
            }else {
                break;
            }
            node = node.getNext();
        }
        return count;
    }

}

package datastructure.LinkedList;

import java.util.Stack;

/**
 * @ClassName algorithm
 * @Author Songleen
 * @Date 2019/08/23/17:55
 * <p>
 * 用来管理英雄
 */
public class SingleLinkedList {

    private HeroNode head = new HeroNode(0, "", "");  //定义一个头节点，什么都不用放

    public HeroNode getHead() {
        return head;
    }

    //添加节点到单向链表
    public void add(HeroNode hero) {
        //找到当前链表的最后节点，因为head节点不能动，因此需要一个辅助的遍历temp
        HeroNode temp = head;
        while (true) {
            if (temp.getNext() == null) {
                break;
            } else {
                temp = temp.getNext();  //如果没有到最后，就将temp后移
            }
        }

        //当退出while循环时，temp就指向了链表的最后
        temp.setNext(hero);
    }

    //添加节点到链表中，按照序号来升序添加
    public void addByNo(HeroNode hero) {
        HeroNode temp = head;
        while (true) {
            if (temp.getNext() == null) {  //说明已经到最后了
                if (temp.getNo() < hero.getNo()) {
                    temp.setNext(hero);
                    break;
                } else {
                    break;
                }
            }
            if (temp.getNext().getNo() > hero.getNo()) {
                hero.setNext(temp.getNext());   //将后面的放在新加入的节点后面
                temp.setNext(hero);
                break;
            } else if (temp.getNext().getNo() == hero.getNo()) {
                System.out.println("添加的节点已经存在，请重新输入");
                break;
            }
            temp = temp.getNext();
        }
    }

    //修改节点的信息，根据no号来修改
    public void update(int no, String name, String nickname) {
        if (head.getNext() == null) {
            System.out.println("链表为空");
            return;
        }
        //根据no找到需要修改的节点
        boolean flag = false;
        HeroNode temp = head.getNext();
        while (true) {
            if (temp == null) {
                break;  //已经遍历完链表
            }
            if (temp.getNo() == no) {
                flag = true;
                break;
            }
            temp = temp.getNext();  //继续遍历
        }
        if (flag) {
            temp.setName(name);
            temp.setNickname(nickname);
        } else {
            System.out.printf("没有找到编号%d的节点，不能修改\n", no);
        }
    }

    //删除节点信息,根据no号来修改，单链表不能够自我删除，必须借助其前面的一个节点
    public void delete(int no) {
        HeroNode temp = head;   //辅助节点
        boolean flag = false;   //标志是否找到了欲删除的节点

        while (true) {
            if (temp.getNext() == null) {    //已到链表的最后,因为没有下一个了
                break;
            }
            if (temp.getNext().getNo() == no) { //找到待删除节点的前一个节点
                flag = true;
                break;
            }
            temp = temp.getNext();
        }

        //判断flag，如果此时找到了，也是待删除节点的前一个节点
        if (flag) {
            HeroNode delNode = temp.getNext();  //待删除节点
            delNode = temp.getNext().getNext(); //将待删除节点换成它的下一个节点
        } else {
            System.out.printf("要删除的%d节点不存在", no);
        }
    }

    //遍历链表
    public void list() {
        if (head.getNext() == null) {
            System.out.println("链表为空");
            return;
        }

        HeroNode temp = head;
        while (true) {
            if (temp == null) {
                break;  //已经到了最后
            }
            System.out.println(temp);   //输出节点信息
            temp = temp.getNext();  //将节点后移
        }
    }

    //求单链表中有效节点的个数
    public static int getLength(HeroNode head) {
        int count = 1;

        if (head.getNext() == null) {    //空链表
            return count;
        }

        HeroNode temp = head;
        while (temp.getNext() != null) {
            count++;
            temp = temp.getNext();

        }
        return count;
    }

    //查找单链表中倒数第k个节点
    public HeroNode getPointedNode(int k, HeroNode node) {
        //先把链表遍历一个遍，得到链表的总长度size，然后从头遍历到size-k个，就得到了想要的节点
        int length = getLength(node);
        if (k <= 0 || k > length) {
            return null;
        }
        HeroNode temp = node;
        for (int i = 0; i <= length - k; i++) {
            if (i == length - k) {
                return temp;
            } else {
                temp = temp.getNext();
            }
        }
        return temp;
    }

    //单链表的反转
    public static void convert(HeroNode head) {
        if (head.getNext() == null || head.getNext().getNext() == null) {
            System.out.println("这是一个空链表，逗我玩呢？");
            return;
        }

        HeroNode cur = head.getNext();
        HeroNode next = null;   //当前节点cur的下一个节点
        HeroNode reservseHead = new HeroNode(0, "", "");

        while (cur != null) {
            //注意，下面这几步的步骤不能更改
            next = cur.getNext();
            cur.setNext(reservseHead.getNext());
            reservseHead.setNext(cur);  //这儿每次进来，就将上一次的值覆盖了
            cur = next; //这一步是保证让cur后移
        }
        head.setNext(reservseHead.getNext());
    }

    /*从尾到头打印单链表
    1、先将单链表反转，然后再打印，但这样破坏了原链表的结构，不推荐
    2、利用栈先进后出的特点实现逆序打印*/
    public static void reverseOrder(HeroNode node) {
        if (node.getNext() == null) {
            System.out.println("这是一个空链表");
            return;
        }

        HeroNode temp = node;
        Stack<HeroNode> stack = new Stack<>();
        while (true) {
            if (temp.getNext() == null) {  //已经到尾部了
                break;
            }
            stack.add(temp.getNext());  //入栈
            temp = temp.getNext();  //老是忘记这一步，导致内存溢出
        }

        while (stack.size() > 0) {
            System.out.println(stack.pop());    //打印栈中的数据
        }
    }

    //合并两个有序的单链表，合并之后的链表依然有序
    public static void merge(HeroNode node1, HeroNode node2) {
        //这里将node2合并到node1中
        if (node1.getNext() == null && node2.getNext() == null) {
            System.out.println("两个链表都为空，怎么玩啊？？？");
            return;
        }

        HeroNode temp = node2;
        while (true) {
            if (temp.getNext() == null) {
                break;
            }
            HeroNode temp2 = node1;
            while (true) {
                if (temp2.getNext() == null) {
                    if (temp2.getNo() < temp.getNo()) {
                        temp2.setNext(temp);
                        break;
                    } else {
                        break;
                    }
                }
                if (temp.getNo() > temp2.getNo() && temp.getNo() < temp2.getNext().getNo()) {
                    temp2.setNext(temp);
                    break;
                }
                temp2 = temp2.getNext();
            }
            temp = temp.getNext();
        }
    }

}

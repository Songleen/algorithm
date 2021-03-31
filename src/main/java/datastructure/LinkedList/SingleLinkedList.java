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

    // 定义一个头节点，什么都不用放
    private HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return head;
    }

    //求单链表中有效节点的个数
    public static int getLength(HeroNode head) {
        int count = 1;

        //空链表
        if (head.getNext() == null) {
            return count;
        }

        HeroNode temp = head;
        while (temp.getNext() != null) {
            count++;
            temp = temp.getNext();

        }
        return count;
    }

    // 从尾到头打印单链表
    // 1、先将单链表反转，然后再打印，但这样破坏了原链表的结构，不推荐
    // 2、利用栈先进后出的特点实现逆序打印
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
    public static HeroNode merge(HeroNode node1, HeroNode node2) {
        //这里将node2合并到node1中
        if (node1.getNext() == null && node2.getNext() == null) {
            System.out.println("两个链表都为空，怎么玩啊？？？");
        }
        if (node1.getNext() == null) {
            return node2;
        }
        if (node2.getNext() == null) {
            return node1;
        }

        HeroNode temp = new HeroNode(0, "", "");
        int curNo = 0;
        HeroNode cur1 = node1.getNext();
        HeroNode cur2 = node2.getNext();

        while (cur1.getNext() != null && cur2.getNext() != null) {
            if (cur1.getNo() >= cur2.getNo()) {
                HeroNode curNode = getNodeByNo(curNo, temp);
                curNode.setNext(cur2);
                curNo++;
                cur2 = cur2.getNext();
            } else {
                HeroNode curNode = getNodeByNo(curNo, temp);
                curNode.setNext(cur1);
                curNo++;
                cur1 = cur1.getNext();
            }
        }
        HeroNode tailNode = getNodeByNo(curNo, temp);
        if (cur1.getNext() != null) {
            tailNode.setNext(cur1);
        }
        if (cur2.getNext() != null) {
            tailNode.setNext(cur2);
        }

        return temp;
    }

    public static HeroNode getNodeByNo(int no, HeroNode node) {
        if (node.getNext() == null) {
            return node;
        }
        while (node.getNext() != null) {
            if (node.getNext().getNo() == no) {
                return node.getNext();
            }
            node = node.getNext();
        }
        return null;
    }

    //添加节点到单向链表
    public void add(HeroNode hero) {
        //找到当前链表的最后节点，因为head节点不能动，因此需要一个辅助的遍历temp
        // 首先要找到该链表的尾节点
        HeroNode temp = head;
        while (true) {
            if (temp.getNext() == null) {
                break;
            } else {
                //如果没有到最后，就将temp后移
                temp = temp.getNext();
            }
        }

        //当退出while循环时，temp就指向了链表的最后
        temp.setNext(hero);
    }

    //添加节点到链表中，按照序号来升序添加
    public void addByNo(HeroNode hero) {
        HeroNode temp = head;
        while (true) {
            //说明已经到最后了
            if (temp.getNext() == null) {
                if (temp.getNo() < hero.getNo()) {
                    temp.setNext(hero);
                }
                break;

            }
            // 判断当前节点的下个节点的序号是否大于要插入的节点，而不是当前节点。因为此处是单向链表，
            // 如果用当前节点，如果它大于被插入节点，没办法把节点插入到当前节点的前面。
            if (temp.getNext().getNo() > hero.getNo()) {
                //将后面的放在新加入的节点后面
                hero.setNext(temp.getNext());
                temp.setNext(hero);
                break;
            } else if (temp.getNext().getNo() == hero.getNo()) {
                System.out.println("添加的节点已经存在，请重新输入");
                break;
            }
            temp = temp.getNext();
        }
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
            //继续遍历
            temp = temp.getNext();
        }
        // 上面的while循环结束后，要么没有，要么就得到了要找的节点。
        if (flag) {
            temp.setName(name);
            temp.setNickname(nickname);
        } else {
            System.out.printf("没有找到编号%d的节点，不能修改\n", no);
        }
    }

    //删除节点信息,根据no号来修改，单链表不能够自我删除，必须借助其前面的一个节点，这个和前面的插入类似
    public void delete(int no) {
        //辅助节点
        HeroNode temp = head;
        //标志是否找到了欲删除的节点
        boolean flag = false;

        while (true) {
            //已到链表的最后,因为没有下一个了
            if (temp.getNext() == null) {
                break;
            }
            //找到待删除节点的前一个节点
            if (temp.getNext().getNo() == no) {
                flag = true;
                break;
            }
            temp = temp.getNext();
        }

        //判断flag，如果此时找到了，也是待删除节点的前一个节点temp
        if (flag) {
            //将待删除节的后一个节点设置
            temp.setNext(temp.getNext().getNext());
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
            //输出节点信息
            System.out.println(temp);
            //将节点后移
            temp = temp.getNext();
        }
    }

    //单链表的反转
    public void convert(HeroNode head) {
        // 从第二个节点开始
        if (head.getNext() == null || head.getNext().getNext() == null) {
            System.out.println("这是一个空链表，逗我玩呢？");
            return;
        }

        // 第一个节点
        HeroNode cur = head.getNext();
        //当前节点cur的下一个节点
        HeroNode next = null;
        HeroNode reservseHead = new HeroNode(0, "", "");

        while (cur != null) {
            //注意，下面这几步的步骤不能更改
            next = cur.getNext();
            cur.setNext(reservseHead.getNext());
            //这儿每次进来，就将上一次的值覆盖了
            reservseHead.setNext(cur);
            //这一步是保证让cur后移
            cur = next;
        }
        head.setNext(reservseHead.getNext());
    }

    // 反转单链表
    public HeroNode convertLink() {
        // 从第二个节点开始
        if (head.getNext() == null || head.getNext().getNext() == null) {
            System.out.println("这是一个空链表，逗我玩呢？");
            return null;
        }
        // 第一个节点,也是当前节点
        HeroNode cur = head.getNext();
        HeroNode reservedHead = new HeroNode(0, "", "");
        // 当前节点的下一个节点
        HeroNode next = null;
        while (cur != null) {
            // 此时next是一个链表
            next = cur.getNext();
            // 当前的下一个应该是之前的前一个，这是为当前元素设置后序元素
            cur.setNext(reservedHead.getNext());
            // 构建反转后的链表
            reservedHead.setNext(cur);
            // 把剩余的节点继续循环
            cur = next;
        }
        return reservedHead;
    }

}

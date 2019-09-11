package datastructure.LinkedList;

/**
 * @ClassName algorithm
 * @Author Songleen
 * @Date 2019/08/24/10:01
 */
public class Test01 {
    public static void main(String[] args) {
        //先创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        HeroNode hero5 = new HeroNode(5, "关羽", "汉寿亭侯");
        HeroNode hero6 = new HeroNode(6, "张飞", "燕人张飞");
        HeroNode hero7 = new HeroNode(7, "赵云", "子龙浑身是胆");
        HeroNode hero8 = new HeroNode(8, "马超", "锦马超");

        //创建链表
        SingleLinkedList linkedList = new SingleLinkedList();
        linkedList.addByNo(hero1);
        linkedList.addByNo(hero2);
        linkedList.addByNo(hero3);
        linkedList.addByNo(hero4);

        /*SingleLinkedList linkedList2 = new SingleLinkedList();
        linkedList2.addByNo(hero6);
        linkedList2.addByNo(hero5);
        linkedList2.addByNo(hero8);
        linkedList2.addByNo(hero7);*/

        //显示
        linkedList.list();

        /*int length = SingleLinkedList.getLength(hero1);
        System.out.println(length);

        //获取倒数第K个节点
        HeroNode pointedNode = linkedList.getPointedNode(1, hero1);
        System.out.println(pointedNode);*/

        SingleLinkedList.convert(linkedList.getHead());
        System.out.println("打印反转之后的链表");
        linkedList.list();

        /*System.out.println("打印用栈实现的逆序功能");
        SingleLinkedList.reverseOrder(linkedList.getHead());

        System.out.println("=============将两个链表合并为一个===============");
        System.out.println("链表1================");
        linkedList.list();
        System.out.println("链表2================");
        linkedList2.list();
        SingleLinkedList.merge(linkedList.getHead(), linkedList2.getHead());
        System.out.println("合并后================");
        linkedList.list();*/

    }
}

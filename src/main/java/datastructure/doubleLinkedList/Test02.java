package datastructure.doubleLinkedList;

/**
 * @ClassName algorithm
 * @Author Songleen
 * @Date 2019/08/24/18:59
 */
public class Test02 {
    public static void main(String[] args) {
        //先创建节点
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 hero4 = new HeroNode2(4, "林冲", "豹子头");
        HeroNode2 hero5 = new HeroNode2(5, "关羽", "汉寿亭侯");

        DoubleLinkedList dLinkedList = new DoubleLinkedList();
        dLinkedList.add(hero1);
        dLinkedList.add(hero2);
        dLinkedList.add(hero3);
        dLinkedList.add(hero4);

        //dLinkedList.update(4, hero5);
        dLinkedList.list();
        int length = DoubleLinkedList.getLength(dLinkedList.getHead());
        System.out.println(length);

        /*dLinkedList.delete(2);
        System.out.println("删除后的双向链表");
        dLinkedList.list();*/
    }
}

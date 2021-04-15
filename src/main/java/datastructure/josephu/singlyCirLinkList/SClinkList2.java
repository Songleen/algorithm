package datastructure.josephu.singlyCirLinkList;

/**
 * @ClassName algorithm
 * @Author Songleen
 * @Date 2021/04/15/19:53
 */
public class SClinkList2 {

    private Person head;

    // 构建环形链表
    public void add(int nums) {
        if (nums <= 0) {
            System.out.println("输入数据不正确！");
        }

        Person curNode = null;
        for (int i = 1; i <= nums; i++) {
            Person newNode = new Person(i, "小孩" + i);
            if (i == 1) {
                head = newNode;
                curNode = newNode;
                continue;
            }
            newNode.setNext(head);
            curNode.setNext(newNode);
            curNode = newNode;
        }
        System.out.println("构建完成！");
    }

    // 遍历环形链表
    public void printLink() {
        Person currentNode = head;
        while (true) {
            if (currentNode == null) {
                System.out.println("链表没有元素，请检查之后再说");
                break;
            }
            System.out.printf("第%d个小孩\n", currentNode.getNo());
            // 到最后了
            if (currentNode.getNext() == head) {
                break;
            }
            currentNode = currentNode.getNext();
        }
    }

    // 玩出圈游戏
    public void palyGame(int startNo, int countNo) {
        // 辅助节点要指向当前节点的前一个节点，这样才能在删除时发挥作用
        Person helper = head;

        // 为helper节点找到位置
        while (helper.getNext() != head) {
            helper = helper.getNext();
        }

        // 首先找到开始位置
        for (int i = 0; i < startNo - 1; i++) {
            head = head.getNext();
            helper = helper.getNext();
        }

        //上面遍历完成之后，就是开始的人
        while (true) {
            // 什么时候游戏结束？
            if (helper == head) {
                break;
            }
            // 自己也要数一下，所以是countNo-1
            for (int i = 0; i < countNo - 1; i++) {
                head = head.getNext();
                helper = helper.getNext();
            }
            System.out.printf("第%d个小朋友出局：\n", head.getNo());
            // 然后删除出局的节点，这时就需要一个辅助节点
            helper.setNext(head.getNext());
            head = head.getNext();
        }
        System.out.printf("获胜者是第%d个小孩：\n", head.getNo());
    }
}

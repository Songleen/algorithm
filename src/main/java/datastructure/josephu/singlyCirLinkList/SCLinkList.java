package datastructure.josephu.singlyCirLinkList;

/**
 * @ClassName algorithm
 * @Author Songleen
 * @Date 2019/08/24/21:45
 * <p>
 * 约瑟夫问题：设编号为1，2，… n的n个人围坐一圈，约定编号为k（1<=k<=n）的人从1开始报数，
 * 数到m 的那个人出列，它的下一位又从1开始报数，数到m的那个人又出列，依次类推，
 * 直到所有人出列为止，由此产生一个出队编号的序列。
 */
public class SCLinkList {

    //创建第一个first节点，没有编号
    private Person first = null;

    //向链表中添加节点
    public void add(int nums) {

        Person curPerson = null;  //辅助指针，帮助构建环形链表

        if (nums < 1) {
            System.out.println(nums + "值不正确，请重新输入");
            return;
        }

        for (int i = 1; i <= nums; i++) {
            Person person = new Person(i, "小朋友" + i);
            if (i == 1) {
                first = person;
                first.setNext(first);   //构成环
                curPerson = first;
            } else {
                curPerson.setNext(person);
                person.setNext(first);
                curPerson = person; //保证curPerson一直指向刚新建的，环一直存在
            }
        }
    }

    //遍历环形链表
    public void showPerson() {
        if (first == null) {
            System.out.println("没有任何小孩");
            return;
        }
        //因为first不能动，因此仍然使用一个辅助指针完成遍历
        Person curPerson = first;
        while (true) {
            System.out.printf("编号%d小孩\n", curPerson.getNo());
            if (curPerson.getNext() == first) {
                break;
            }
            curPerson = curPerson.getNext();
        }
    }

    //根据用户的输入，确定小孩的出圈顺序
    public void solve(int startNo, int countNum, int nums) {
        //先对数据进行校验
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("参数输入有误，请重新输入");
            return;
        }

        add(nums);  //向链表中添加节点

        // 创建一个辅助指针,让它一直跟在first后面，这样当first要被删除时，直接通过辅助指针来设置
        // 因为是单向链表，所以移除节点的时候需要用到辅助指针
        //当下面这个while循环结束之后，helper就跑到链表的最后，也就是first后面了
        Person helper = first;
        while (true) {
            //已到末尾
            if (helper.getNext() == first) {
                break;
            }
            helper = helper.getNext();
        }

        //小孩报数前，先让first和helper移动k-1次，因为自己要数一下，
        //也就是要找到开始的位置
        for (int i = 0; i < startNo - 1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }

        //当小孩开始报数时，让first和hepler同时移动countNum-1次(因为自己要数一下),
        // 这里是一个循环，直到圈中只有一个节点
        while (true) {
            //说明圈中只有一个节点
            if (helper == first) {
                break;
            }
            for (int j = 0; j < countNum - 1; j++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            //这是first指向的节点，就是要出圈的节点
            System.out.printf("小孩%d出圈\n", first.getNo());
            first = first.getNext();

            // 这是删除节点的代码
            helper.setNext(first);
        }
        System.out.printf("最后留在圈中的小孩编号%d", first.getNo());
    }
}

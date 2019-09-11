package datastructure.hashTable;

/**
 * @ClassName algorithm
 * @Author Songleen
 * @Date 2019/09/02/17:35
 * <p>
 * 表示链表
 */
public class EmpLinkedList {

    //头指针，执行一个Emp,因此我们这个链表的head是直接指向第一个Emp
    private Emp head;   //默认null

    //添加雇员到链表
    public void add(Emp emp) {
        if (emp == null) {
            System.out.println("对象为空，请重新输入");
            return;
        }

        //如果添加的是第一个雇员
        if (head == null) {
            head = emp;
            return;
        }

        Emp cur = head;
        //用while循环添加雇员到链表最后
        while (true) {
            if (cur.getNext() == null) {
                break;
            }
            cur = cur.getNext();
        }
        cur.setNext(emp);
    }

    //遍历链表
    public void list(int no) {
        if (head == null) {
            System.out.println("第" + (no + 1) + "链表为空，怎么遍历");
            return;
        }

        System.out.print("第" + (no + 1) + "链表的信息为：");
        Emp curEmp = head;    //辅助指针
        while (true) {
            System.out.printf("=>id=%d name=%s\t", curEmp.getId(), curEmp.getName());
            if (curEmp.getNext() == null) {
                break;
            }
            curEmp = curEmp.getNext();
        }
        System.out.println();
    }

    //根据id查找雇员
    public Emp getEmpById(int id) {

        Emp temp = head;
        if (temp == null) {
            System.out.println("链表为空");
            return null;
        }
        while (true) {
            if (temp.getNext() == null) {
                break;
            }
            if (temp.getId() == id) {
                return temp;
            }
            temp = temp.getNext();
        }
        return null;
    }
}

package datastructure.hashTable.hashdemo1;

/**
 * @ClassName algorithm
 * @Author Songleen
 * @Date 2019/12/17/14:00
 */
public class StudentLinkedList {
    private Student head;

    public void add(Student student) {
        if (student == null) {
            System.out.println("输入对象为空，无法加入");
        }
        if (head == null) {
            head = student;
            return;
        }

        //辅助指针，用于接收链表最后一个节点
        Student assistCur = head;
        while (true) {
            if (assistCur.getNext() == null) {
                break;
            }
            assistCur = assistCur.getNext(); //接收最后一个节点
        }
        assistCur.setNext(student);
    }

    public void list(int no) {
        if (head == null) {
            System.out.println("第" + (no + 1) + "号链表没有元素，如何遍历？");
            return;
        }
        System.out.println("第" + (no + 1) + "号链表的数据为：");
        Student assistCur = head;
        while (true) {
            System.out.printf("=>id=%d name=%s\t", assistCur.getId(), assistCur.getName());
            if (head.getNext() == null) {
                break;
            }
            assistCur = assistCur.getNext();
        }
        System.out.println();
    }

    public Student getById(int id) {
        if (head == null) {
            System.out.println("链表中没有数据，也没有你想要的东西!!");
        }
        Student assistCur = head;
        while (true) {
            if (assistCur.getId() == id) {
                return assistCur;
            }
            if (assistCur.getNext() == null) {
                System.out.println("没有找到对应的学生信息");
                return null;
            }
            assistCur = assistCur.getNext();
        }
    }
}

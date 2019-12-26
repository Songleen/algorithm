package datastructure.hashTable.hashdemo1;

/**
 * @ClassName algorithm
 * @Author Songleen
 * @Date 2019/12/17/14:52
 */
public class HashTableDemo1 {
    private StudentLinkedList[] studentLinkedLists;
    private int size;

    public HashTableDemo1(int size) {
        this.size = size;
        studentLinkedLists = new StudentLinkedList[size];
        for (int i = 0; i < size; i++) {
            studentLinkedLists[i] = new StudentLinkedList();
        }
    }

    private int hashFun(int id) {
        return id % size;
    }

    public void addStudent(Student student) {
        if (student == null) {
            System.out.println("什么都没有，怎么加？？");
            return;
        }
        int index = hashFun(student.getId());
        studentLinkedLists[index].add(student);
    }

    public void listHashTable() {
        for (int i = 0; i < studentLinkedLists.length; i++) {
            studentLinkedLists[i].list(i);
        }
    }

    public void getStudentById(int id) {
        int index = hashFun(id);
        Student student = studentLinkedLists[index].getById(id);
        if (student != null) {
            System.out.printf("在第%d条链表中找到雇员id=$d\n", (student.getId() + 1), id);
        } else {
            System.out.println("在hash表中，没有找到该学生");
        }
    }
}

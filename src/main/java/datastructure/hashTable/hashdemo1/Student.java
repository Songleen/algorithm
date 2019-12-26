package datastructure.hashTable.hashdemo1;

/**
 * @ClassName algorithm
 * @Author Songleen
 * @Date 2019/12/17/13:58
 * <p>
 * 表示一个学生
 */
public class Student {

    private Integer id;
    private String name;
    private Student next;

    public Student(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student getNext() {
        return next;
    }

    public void setNext(Student next) {
        this.next = next;
    }
}

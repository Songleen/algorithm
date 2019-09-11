package datastructure.josephu.singlyCirLinkList;

/**
 * @ClassName algorithm
 * @Author Songleen
 * @Date 2019/08/24/21:41
 */
public class Person {
    private int no;
    private String name;
    private Person next;

    public Person(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person getNext() {
        return next;
    }

    public void setNext(Person next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Person{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}

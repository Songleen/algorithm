package datastructure.hashTable;

/**
 * @ClassName algorithm
 * @Author Songleen
 * @Date 2019/09/02/17:59
 * <p>
 * 创建hash表管理管理多个链表
 */
public class HashTab {
    private EmpLinkedList[] empLinkedLists; //注意，这里是数组，不是集合
    private int size;   //表示有多少个链表

    public HashTab(int size) {
        this.size = size;
        empLinkedLists = new EmpLinkedList[size];  //初始化
        for (int i = 0; i < size; i++) {
            empLinkedLists[i] = new EmpLinkedList();
        }
    }

    //编写一个散列函数，使用一个简单的取模方法
    public int hashFun(int id) {
        return id % size;
    }

    //添加雇员
    public void addEmp(Emp emp){
        int index = hashFun(emp.getId());
        empLinkedLists[index].add(emp);
    }

    //遍历所有的链表，遍历hashtab
    public void listTable(){
        for (int i = 0; i < size; i++) {
            empLinkedLists[i].list(i);
        }
    }

    //根据输入的id查找雇员
    public void getEmpById(int id){
        int empLinkedNo = hashFun(id);
        Emp emp = empLinkedLists[empLinkedNo].getEmpById(id);
        if (emp != null){
            System.out.printf("在第%d条链表中找到雇员id=$d\n",(emp.getId()+1),id);
        }else {
            System.out.println("在哈希表中，没有找到该雇员");
        }
    }
}

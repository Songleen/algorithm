package datastructure.hashTable.hashdemo1;

import java.util.Scanner;

/**
 * @ClassName algorithm
 * @Author Songleen
 * @Date 2019/12/17/15:17
 */
public class Test2 {
    public static void main(String[] args) {
        //创建hash表
        HashTableDemo1 hashTableDemo1 = new HashTableDemo1(4);

        //写一个简单的菜单
        String key = "";
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("add: 添加雇员");
            System.out.println("list: 显示雇员");
            System.out.println("find: 查找雇员");
            System.out.println("exit: 退出系统");

            key = scanner.next();
            switch (key) {
                case "add":
                    System.out.println("输入id");
                    int id = scanner.nextInt();
                    System.out.println("输入名字");
                    String name = scanner.next();
                    Student student = new Student(id, name);
                    hashTableDemo1.addStudent(student);
                    break;
                case "list":
                    hashTableDemo1.listHashTable();
                    break;
                case "find":
                    System.out.println("输入id:");
                    id = scanner.nextInt();
                    hashTableDemo1.getStudentById(id);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }
    }
}

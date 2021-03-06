package datastructure.hashTable;

import java.util.Scanner;

/**
 * @ClassName algorithm
 * @Author Songleen
 * @Date 2019/09/02/18:32
 */
public class Test1 {
    public static void main(String[] args) {
        //创建哈希表
        HashTab hashTab = new HashTab(3);

        //写一个简单的菜单
        String key ="";
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("add: 添加雇员");
            System.out.println("list: 显示雇员");
            System.out.println("find: 查找雇员");
            System.out.println("exit: 退出系统");

            key = scanner.next();
            switch (key){
                case "add":
                    System.out.println("输入id");
                    int id = scanner.nextInt();
                    System.out.println("输入名字");
                    String name = scanner.next();

                    //创建雇员
                    Emp emp = new Emp(id, name);
                    hashTab.addEmp(emp);
                    break;
                case "list":
                    hashTab.listTable();
                    break;
                case "find":
                    System.out.println("请输入要查找的id");
                    id = scanner.nextInt();
                    hashTab.getEmpById(id);
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

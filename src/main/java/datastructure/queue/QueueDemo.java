package datastructure.queue;

import java.util.Scanner;

/**
 * @ClassName algorithm
 * @Author Songleen
 * @Date 2019/08/22/17:16
 */
public class QueueDemo {
    public static void main(String[] args) {
        //创建一个对队列，居然有队列！！！
        ArraysQueue queue = new ArraysQueue(3);
        char key = ' ';
        Scanner s = new Scanner(System.in);
        boolean loop = true;
        //输出一个菜单
        while (loop) {
            System.out.println("s:显示队列");
            System.out.println("e:退出队列");
            System.out.println("a:向队列中添加数据");
            System.out.println("g:从队列中获取数据");
            System.out.println("h:查看队列头的数据");
            key = s.next().charAt(0);
            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("输入一个数：");
                    int value = s.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g':
                    int res = queue.getQueue();
                    System.out.printf("取出的数据是%d\n", res);
                    break;
                case 'h':
                    int head = queue.showHead();
                    System.out.printf("队列头的数据是%d\n", head);
                    break;
                case 'e':
                    s.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出……");
    }
}


//使用数组模拟一个队列--编写一个ArrayQueue类
class ArraysQueue {
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    //创建队列的构造器
    public ArraysQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = -1; //指向队列头部，分析出front是指向队列头的前一个位置，作为数组下标使用
        rear = -1;  //指向队列尾部，指向队列尾部的数据，作为数组下标使用
    }
    //判断队列是否已满
    public boolean isFull() {
        return rear == maxSize - 1;
    }
    //判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }
    //添加数据到队列
    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列已满，不能添加新的数据");
            return;
        }
        // 添加进来的数据永远在后面，这样方便取值。如果添加进来的值一直放前面，应该会方便存值
        rear++;
        arr[rear] = n;
    }

    //获取队列的数据,出列
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，不能获取数据");
        }
        front++;
        return arr[front];
    }

    //显示队列中的所有数据
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空，没有数据");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }

    //显示队列头数据
    public int showHead() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，没有数据~~");
        }
        return arr[front + 1];
    }
}
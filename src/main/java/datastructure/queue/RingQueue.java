package datastructure.queue;

import java.util.Scanner;

/**
 * @ClassName algorithm
 * @Author Songleen
 * @Date 2019/08/23/14:33
 */
public class RingQueue {
    public static void main(String[] args) {
        //创建一个环形队列，居然有队列！！！
        CircularQueue queue = new CircularQueue(4); //这里实际大小是3，因为保留了一个位置，目的为了代码更容易阅读；
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

//使用数组模拟一个队列--编写一个CircularQueue类
class CircularQueue {
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    //创建队列的构造器
    public CircularQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = 0; //指向队列头部，指向队列头部第一个元素；
        rear = 0;  //指向队列尾部，指向队列尾部最后一个元素的后一个位置；预留一个空间作为约定，什么约定还不清楚
    }

    //判断队列是否已满
    public boolean isFull() {
        return (rear + 1) % maxSize == front;   //如果队列头有值被取出，则没有满
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
        arr[rear] = n;
        rear = (rear + 1) % maxSize;
    }

    //获取队列的数据,出列
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，不能获取数据");
        }
        int result = arr[front];
        front = (front + 1) % maxSize;
        return result;
    }

    //显示队列中的所有数据
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空，没有数据");
            return;
        }
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    //显示队列头数据
    public int showHead() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，没有数据~~");
        }
        return arr[front];
    }

    //当前队列有效数据的个数
    public int size() {
        return (rear + maxSize - front) % maxSize;
    }
}

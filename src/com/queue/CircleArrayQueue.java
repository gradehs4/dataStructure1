package com.queue;

import java.util.Scanner;

/**
 * 环形队列
 */
public class CircleArrayQueue {
    public static void main(String[] args) {
      //  ArrayQueue arrayQueue = new ArrayQueue(3);
        CircleArray circleArray = new CircleArray(4);//其队列最大有效的数据是3
        //char key ="";
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        //输出一个菜单
        while (loop) {
            System.out.println("s:显示队列");
            System.out.println("e:退出程序");
            System.out.println("a:添加数据到队列");
            System.out.println("g:从队列出数据");
            System.out.println("h:查询队列头的数据");
            char key = scanner.next().charAt(0);//接收一个字符
            switch (key) {
                case 's':
                    try {
                        circleArray.showQueue();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'a':
                    System.out.println("输出一个数");
                    int i1 = scanner.nextInt();
                    circleArray.addQueue(i1);
                    break;
                case 'g':
                    try {
                        int res = circleArray.getQueue();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int i = circleArray.headQueue();
                        System.out.printf("取出的头数据是%d\n", i);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e'://完美的想法
                    scanner.close();
                    loop = false;
                    break;

                default:
                    break;

            }
        }
        System.out.println("程序退出~~~~~");

    }
}
class CircleArray{
    private int maxSize;//表示数组的最大容量
    //front 变量的含义做一个调整：front就指向队列的第一个元素，也就是说arr[front] front的初始值=0
    private int front;//表示队列的头
    //rear 变量的含义做了一个调整：rear指向队列的最后一个元素的后一个位置，希望空出一个位置 rear的初始值=0
    private int rear;//表示队列的尾部
    private int[] arr;//该数组用于存放数据，模拟队列

    public CircleArray(int arrMaxSize){
        maxSize=arrMaxSize;
        arr=new int[maxSize];

    }

    //判断队列是否满了
    public boolean isFull(){
        return (rear+1)%maxSize==front;
    }

    public boolean isEmpty(){
        return rear==front;
    }

    public void addQueue(int n){
        if(isFull()){
            System.out.println("队列已满，不能加入数据");
            return;
        }
        //直接将数据加入
        arr[rear]=n;
        //将rear后移，这里必须考虑取模
        rear= (rear + 1) % maxSize;

    }
    //获取队列数据，出队列
    public int getQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空不能取数据");
        }
        //这里需要分析出front是指向队列的第一个元素
        //1.先把front对应的值保留到一个临时变量
        //2.将front后移，考虑取模
        //3.将临时保存的变量返回
        int value = arr[front];
        front =(front +1) % maxSize;
        return value;
    }

    public void showQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空没有数据展示");
        }
        //思路：从front开始遍历，遍历多少个元素
        //遍历(rear + maxsize-front)%maxsize
        for (int i = front; i < front+(rear + maxSize-front)%maxSize; i++) {
            System.out.printf("arr[%d]=%d\n",i%maxSize,arr[i%maxSize]);
        }
    }

    public int headQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空，没有头数据");
        }
        return arr[front];
    }
}

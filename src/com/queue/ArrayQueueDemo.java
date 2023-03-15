package com.queue;

import java.util.Scanner;

public class ArrayQueueDemo {

    public static void main(String[] args) {

        //测试一把
        //创建一个队列
        ArrayQueue arrayQueue = new ArrayQueue(3);
        Scanner scanner = new Scanner(System.in);
        boolean loop =true;
        //输出一个菜单
        while (loop){
            System.out.println("s:显示队列");
            System.out.println("e:退出程序");
            System.out.println("a:添加数据到队列");
            System.out.println("g:从队列出数据");
            System.out.println("h:查询队列头的数据");
            char key =scanner.next().charAt(0);//接收一个字符
            switch (key){
                case 's':
                    try {
                        arrayQueue.showQueue();
                    } catch (Exception e) {
                        System.out.println( e.getMessage());
                    }
                    break;
                case 'a':
                    System.out.println("输出一个数");
                    int i1 = scanner.nextInt();
                    arrayQueue.addQueue(i1);
                    break;
                case 'g':
                    try {
                        int  res = arrayQueue.getQueue();
                        System.out.printf("取出的数据是%d\n",res);
                    } catch (Exception e) {
                         System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int i = arrayQueue.headQueue();
                        System.out.printf("取出的头数据是%d\n",i);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e'://完美的想法
                    scanner.close();
                    loop=false;
                    break;

                default:
                    break;

            }
        }
        System.out.println("程序退出~~~~~");
    }
}
//使用数组模拟队列编写一个ArrayQueue类
class ArrayQueue{
    private int maxSize;//表示数组的最大容量
    private int front;//表示队列的头
    private int rear;//表示队列的尾部
    private int[] arr;//该数组用于存放数据，模拟队列

    //创建队列的构造器
    public ArrayQueue(int arrMaxSize){
        maxSize=arrMaxSize;
        arr=new int[maxSize];
        front=-1;//指向头部的前一个位置
        rear=-1;//指向尾部的数据
    }
    //判断队列是否满了
    public boolean isFull(){
        return rear==maxSize-1;
    }

    public boolean isEmpty(){
        return rear==front;
    }

    public void addQueue(int n){
        if(isFull()){
            System.out.println("队列已满，不能加入数据");
            return;
        }
        rear++;//rear向后移动
        arr[rear]=n;
    }
    //获取队列数据，出队列
    public int getQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空不能取数据");
        }
        front++;
        return arr[front];
    }

    public void showQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空没有数据展示");
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }
    }

    public int headQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空，没有头数据");
        }
        return arr[front+1];
    }

}


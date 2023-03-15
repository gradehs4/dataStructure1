package com.stack;

import java.util.Scanner;

public class ArrayStackDemo {
    public static void main(String[] args) {
        //测试一下ArrayStack是否正确
        //先创建一个ArrayStack对象表示栈
        ArrayStack stack = new ArrayStack(4);
        String key = null;
        boolean loop = true;//控制是否退出菜单
        Scanner scanner = new Scanner(System.in);

        while (loop){
            System.out.println("show:表示显示栈");
            System.out.println("exit:退出程序");
            System.out.println("push:表示添加数据到栈");
            System.out.println("pop:表示从栈中取出数据");
            System.out.println("请输入内容------");
            key = scanner.next();
            switch (key){
                case "show":
                    stack.list();
                    break;
                case "push":
                    System.out.println("请输入一个数");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case "pop":
                    try {
                        int pop = stack.pop();
                        System.out.printf("出栈的数据时%d\n",pop);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());;
                    }
                    break;
                case "exit":
                    scanner.close();
                    loop = false;
                    break;

            }
        }
        System.out.println("程序退出了~~");

    }
}

//定义一个ArrayStack表示栈
class ArrayStack{
    private int maxSize; //栈的大小
    private int[] stack; //数组，数组模拟栈，数据就放在改数组
    private int top = -1;//top表示栈顶，初始化为-1
    //构造器
    public ArrayStack(int maxSize){
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }
    //栈满
    public boolean isFull(){
        return top == maxSize -1;
    }

    //栈空
    public boolean isEmpty(){
        return top == -1;
    }

    //入栈操作
    public void push(int data){
         //先判断栈是否满
        if(isFull()){
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top]=data;

    }
    //出栈操作
    public int  pop(){
        //先判断栈是否为空
        if(isEmpty()){
            //抛出异常
            throw new RuntimeException("栈空，没有数据");
        }
       int value = stack[top];
        top--;
        return value;
    }

    //显示栈的情况【遍历栈】,遍历时，需要从栈顶开始显示数据
    public void list(){
      if(isEmpty()){
          System.out.println("栈空，没有数据~~");
          return;
      }
      //需要从栈顶开始显示数据
        for (int i = top; i >-1; i--) {
            System.out.printf("stack[%d]=%d\n",i,stack[i]);
        }
    }





}

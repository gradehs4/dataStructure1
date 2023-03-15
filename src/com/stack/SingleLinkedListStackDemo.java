package com.stack;


import java.util.Scanner;

public class SingleLinkedListStackDemo {
    public static void main(String[] args) {

        SingleLinkedList listStack = new SingleLinkedList();
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
                    listStack.List();
                    break;
                case "push":
                    System.out.println("请输入一个数");
                    int value = scanner.nextInt();
                    HeroNode node = new HeroNode(value);
                    listStack.push(node);
                    break;
                case "pop":
                    try {
                        HeroNode pop = listStack.pop();
                        System.out.printf("出栈的数据是%d\n",pop.no);
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

//定义singlelinkedList
class SingleLinkedList {
    //初始化一个头结点，头结点不要动，不存放具体数据
    private HeroNode head = new HeroNode(0);

    public HeroNode getHead() {
        return head;
    }

    public void setHead(HeroNode head) {
        this.head = head;
    }

    public void push(HeroNode heroNode){
        HeroNode temp = head;
        heroNode.next=temp.next;
        temp.next=heroNode;
    }

    public HeroNode pop(){
        if(head.next==null){
            throw new RuntimeException("栈空，没有数据");
        }

        HeroNode cur = null;
         cur = head.next;
         head.next= head.next.next;
         return cur;
    }

    public void List(){

        //判断是否为空
        if(head.next==null){
            System.out.println("栈为空");
            return;
        }
        //因为头结点不动，因此需要一个辅助变量来遍历
       HeroNode temp = head.next;
        while (true){
            //判断是否到链表最后
            if(temp == null){
                break;
            }
            System.out.printf("%d\n",temp.no);
            //将temp后移
            temp = temp.next;
        }
    }

}



//定义HeroNode,每个HeroNode对象就是一个节点
class HeroNode{
    public int no;
    public HeroNode next; //指向下一个节点

    public HeroNode(int no){
        this.no=no;

    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                '}';
    }
}
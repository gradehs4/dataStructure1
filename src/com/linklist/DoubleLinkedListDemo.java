package com.linklist;

public class DoubleLinkedListDemo {
    public static void main(String[] args) {

        System.out.println("双向链表的测试");
        //先创建节点
        HeroNode1 heroNode1 = new HeroNode1(2, "宋江", "及时雨");
        HeroNode1 heroNode2 = new HeroNode1(4, "卢俊义", "玉麒麟");
        HeroNode1 heroNode3 = new HeroNode1(6, "吴用", "智多星");
        HeroNode1 heroNode4 = new HeroNode1(8, "林冲", "豹子头");
        HeroNode1 heroNode5 = new HeroNode1(8, "林", "豹子头");
        //创建一个双向链表
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
//        doubleLinkedList.add(heroNode3);
//        doubleLinkedList.add(heroNode1);
//        doubleLinkedList.add(heroNode2);
//        doubleLinkedList.add(heroNode4);

        doubleLinkedList.add1(heroNode1);
        doubleLinkedList.add1(heroNode3);
        doubleLinkedList.add1(heroNode2);
        doubleLinkedList.add1(heroNode4);


        doubleLinkedList.List();

//        System.out.println("~~~~~~~~~~~~~~~~");
//        doubleLinkedList.update(heroNode5);
//        doubleLinkedList.List();
//
//        System.out.println("~~~~~~~~~~~~~~~~");
//        doubleLinkedList.delete(heroNode5);
//        doubleLinkedList.List();


    }
}

//创建一个双向链表的类
class DoubleLinkedList{
    //先初始化一个头结点，头结点不要动，不存放具体的数据
    private HeroNode1 head = new HeroNode1(0,"","");

    //返回头结点
    public HeroNode1 getHead(){
        return head;
    }

    //遍历双向链表的方法
    //显示链表【遍历】
    public void List(){

        //判断是否为空
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }
        //因为头结点不动，因此需要一个辅助变量来遍历
        HeroNode1 temp = head.next;
        while (true){
            //判断是否到链表最后
            if(temp == null){
                break;
            }
            System.out.println(temp);
            //将temp后移
            temp = temp.next;
        }
    }

    //添加双向链表节点
    public void add(HeroNode1 heroNode){
        //创建临时变量查询节点的next域
        HeroNode1 temp = head;
        while (true) {
            if (temp.next == null) {
                temp.next = heroNode;
                heroNode.pre=temp;
                break;
            }
            temp = temp.next;
        }
    }

    public void add1(HeroNode1 heroNode){

        HeroNode1 temp= head;
        boolean flag = false; //flag标志添加的编号是否存在，默认为false
        while (true){
            if(temp.next == null){//说明temp已经到了队尾
                break;
            }
            if(temp.next.no>heroNode.no){ //位置找到，就在temp的后面插入
                break;
            }else if(temp.next.no == heroNode.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //判断flag的值
        if(flag){//不能添加，说明编号存在
            System.out.printf("准备插入的英雄编号 %d 已经存在,不能加入\n",heroNode.no);
            return;
        }

       heroNode.next=temp.next;
        if(temp.next!=null){//当双链表是空时，插入节点的前驱节点会出现空指针异常，请注意
        temp.next.pre=heroNode;
        }
        heroNode.pre=temp;
        temp.next=heroNode;


    }

    //修改双向链表中的值
    public void update(HeroNode1 heroNode){
        //判断链表是否为空
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }
        HeroNode1 temp = head;
        while(true){
            if(temp.next==null){
                System.out.printf("链表循序完成，没找到要编号为%d节点\n",heroNode.no);
                break;
            }
            if(temp.next.no == heroNode.no){
                temp.next.name=heroNode.name;
                temp.next.nickname=heroNode.nickname;
                System.out.println("修改完成");
                break;
            }
            temp=temp.next;
        }
    }

    //删除节点的信息，根据no编号来修改，即no编号不能改
    //说明
    public void delete(HeroNode1 heroNode){
        //判断链表是否为空
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }
        HeroNode1 temp = head.next;
        while(true){
            if(temp==null){
                System.out.printf("链表循序完成，没找到要编号为%d节点\n",heroNode.no);
                break;
            }
            if(temp.no == heroNode.no){
                temp.pre.next=temp.next;
                //如果是最后一个节点，就不需要执行下面这句话，否则出现空指针异常
                if(temp.next!=null) {
                    temp.next.pre = temp.pre;
                }
                System.out.println("删除完成");
                break;
            }
            temp=temp.next;
        }
    }
}

//定义HeroNode,每个HeroNode对象就是一个节点
class HeroNode1 {
    public int no;
    public String name;
    public String nickname;
    public HeroNode1 next; //指向下一个节点
    public HeroNode1 pre;//指向前一个节点

    public HeroNode1(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}

package com.linklist;

import java.util.Stack;

public class SingleLinkedListDemo {
    public static void main(String[] args) {

        SingleLinkedList singleLinkedList1 = new SingleLinkedList();
        HeroNode heroNode1 = new HeroNode(2, "宋江", "及时雨");
        HeroNode heroNode2 = new HeroNode(4, "卢俊义", "玉麒麟");
        HeroNode heroNode3 = new HeroNode(6, "吴用", "智多星");
        HeroNode heroNode4 = new HeroNode(8, "林冲", "豹子头");
        //HeroNode heroNode5 = new HeroNode(4, "林教头", "豹子头");


        SingleLinkedList singleLinkedList2 = new SingleLinkedList();
        HeroNode heroNode6 = new HeroNode(1, "宋", "及时雨");
        HeroNode heroNode7 = new HeroNode(3, "卢", "玉麒麟");
        HeroNode heroNode8 = new HeroNode(5, "吴", "智多星");
        HeroNode heroNode9 = new HeroNode(7, "林", "豹子头");

       // SingleLinkedList singleLinkedList3 = new SingleLinkedList();

        singleLinkedList1.add1(heroNode1);
        singleLinkedList1.add1(heroNode3);
        singleLinkedList1.add1(heroNode2);
        singleLinkedList1.add1(heroNode4);
        singleLinkedList1.List();

//        System.out.println("~~~~~~~~~~~~~~~~~~~");
//        singleLinkedList2.add1(heroNode6);
//        singleLinkedList2.add1(heroNode7);
//        singleLinkedList2.add1(heroNode8);
//        singleLinkedList2.add1(heroNode9);
//        singleLinkedList2.List();
//
//        System.out.println("~~~~~~~~~~~~~~~~~~~");
//        SingleLinkedList list = heBinLb(singleLinkedList1, singleLinkedList2);
//        list.List();

//        System.out.println("修改后~~~~~~~~~~~~~~");
//
//        singleLinkedList.update(heroNode5);
//        singleLinkedList.List();
//
//        System.out.println("删除后~~~~~~~~~~~~~~");
//       singleLinkedList.List();
      //  System.out.println("~~~~~~~~~~~~~~~~~~~");
//        System.out.println(singleLinkedList.getLastIndex(1));
//        singleLinkedList.reversetList();
//        singleLinkedList.List();
      //  singleLinkedList1.reversePrint();

    }
         //将两个有序的单链表合并成一个有序的单链表
    public static SingleLinkedList heBinLb(SingleLinkedList s1,SingleLinkedList s2){
       HeroNode temp1 = s1.getHead().next;
       HeroNode temp2 = s2.getHead().next;
        SingleLinkedList list = new SingleLinkedList();
        HeroNode temp3 = list.getHead();
        HeroNode cur =null;
        if(temp1==null && temp2 ==null){
            return null;
        }
        if(temp1==null ){
           temp3.next=temp2;
       }else {
            temp3.next=temp1;
            while (temp2 != null) {

                if (temp3.next == null) {
                    temp3.next = temp2;
                    break;
                }

                if (temp2.no<=temp3.next.no) {
                    cur = temp2.next;
                    temp2.next = temp3.next;
                    temp3.next = temp2;
                    temp2 = cur;
                }
                temp3 = temp3.next;


            }
        }
        return list;
    }


}
//定义singlelinkedList链表管理英雄
class SingleLinkedList{
    //初始化一个头结点，头结点不要动，不存放具体数据
   private HeroNode head= new HeroNode(0,"","");

    public HeroNode getHead() {
        return head;
    }

    public void setHead(HeroNode head) {
        this.head = head;
    }
    //添加节点到单链表
    //思路，当不考虑编号顺序
    //1.找到当前链表的最后节点
    //2.将最后这个节点的next指向新的节点

    public void add(HeroNode heroNode){
        //创建临时变量查询节点的next域
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                temp.next = heroNode;
                break;
            }
            temp = temp.next;
        }
    }

    //第二种方式添加英雄时，根据排名将英雄插入到指定位置
    //（如果有这个排名，则添加失败，并给出提示）

    public void add1(HeroNode heroNode){

        HeroNode temp= head;
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
        heroNode.next = temp.next ;
        temp.next= heroNode;
    }

    //修改节点的信息，根据no编号来修改，即no编号不能改
    //说明
    //1.根据newHeroNode的no来修改即可
    public void update(HeroNode heroNode){
        //判断链表是否为空
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head;
        while (true){
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
    public void delete(HeroNode heroNode){
        //判断链表是否为空
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head;
        while (true){
            if(temp.next==null){
                System.out.printf("链表循序完成，没找到要编号为%d节点\n",heroNode.no);
                break;
            }
            if(temp.next.no == heroNode.no){
                temp.next=temp.next.next;
                System.out.println("删除完成");
                break;
            }
            temp=temp.next;
        }
    }

    //方法：获取到单链表的节点的个数（如果时带头结点，需要不统计头结点）
    public int getLength(){
        if(head.next==null){
            return 0;
        }
        HeroNode cur =head.next;
        int length =1;
        while (true){
            if (cur.next==null){
                return length;
            }
            length++;
            cur=cur.next;

        }
    }
    //查找单链表中的倒数第K个节点【新浪面试题】
    //思路
    //1.编写一个方法，接收一个index
    //2.index表示是倒数第index个节点
    //3.先把链表遍历，得到链表的总长度
    //4.得到size后，我们从链表的第一个开始遍历（size-index）个，就可以得到
    public HeroNode getLastIndex(int index){
      if (head.next==null){
          return null;
      }
      HeroNode temp =head.next;
        int size = getLength();
        int cur=0;
      if(size<=0||index>size){
          return null;
      }
       while (true){

           if(cur == size-index){
               return temp;
           }
           cur++;
           temp=temp.next;
       }

    }

    //单链表反转【腾讯面试题，有点难度】
    public void reversetList(){
        //如果当前链表为空，或者只有一个节点，无需反转，直接返回
        if(head.next==null||head.next.next==null){
            return;
        }
        //定义一个辅助指针（变量），帮助我么遍历原来的链表
        HeroNode cur = head.next;
        HeroNode next = null;//指向当前节点[cur]的下一个节点
        HeroNode reverseHead = new HeroNode(0, "", "");
        //遍历原来的链表，每个遍历一个节点，就将其取出，并存放在新的链表reverseHead的最前端
        while (cur!=null){
            next = cur.next;//先保存当前节点的下一个节点，因为后面需要使用
            cur.next = reverseHead.next;//将cur的下一个节点指向新的链表的最前端
            reverseHead.next=cur;//将cur连接到新的链表上
            cur = next;//让cur后移

        }
        //将head.next指向reverseHead.next,实现单链表的反转
        head.next=reverseHead.next;
    }

    //方式2：
    //可以利用栈这个数据结构，将各节点压入到栈中，然后利用栈的先进后出的特点，就实现了逆序打印的效果
    public void reversePrint(){
        if(head.next==null){
            return;//空链表不能打印
        }
        //创建要给的一个栈，将各节点压入栈
        Stack<HeroNode> stack = new Stack<HeroNode>();
        HeroNode temp = head.next;
        while (temp!=null){
            stack.push(temp);//将节点压入栈
            temp = temp.next;
        }

        //将栈中的节点进行打印，pop出栈
        while (stack.size()>0){
            System.out.println(stack.pop());
        }


    }

    public void List(){

        //判断是否为空
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }
        //因为头结点不动，因此需要一个辅助变量来遍历
        HeroNode temp = head.next;
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
}


//定义HeroNode,每个HeroNode对象就是一个节点
class HeroNode{
    public int no;
    public String name;
    public String nickname;
    public HeroNode next; //指向下一个节点

    public HeroNode(int no,String name,String nickname){
        this.no=no;
        this.name=name;
        this.nickname=nickname;
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

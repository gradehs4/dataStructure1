package com.linklist;

public class Josepfu {
    public static void main(String[] args) {

        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(5);//加入五个小孩节点
        circleSingleLinkedList.showBoy();

        //测试一把小孩出圈是否正确
        circleSingleLinkedList.countBoy(1,2,5);//2->4->1->5->3

    }
}
//创建一个环形的单向链表

class CircleSingleLinkedList{
    //创建一个first节点，当前没有编写
    private Boy first = null;
    //添加小孩节点，构成一个环形的链表
    public void addBoy(int nums){
        //nums 做一个数据校验
        if (nums<1){
            System.out.println("nums的值不正确");
            return;
        }
        Boy curBoy = null;//辅助指针，帮助构建环形链表
        //使用for来创建环形链表
        for (int i = 1; i <=nums; i++) {
            Boy boy = new Boy(i);
            if(i==1){
                first=boy;
                first.setNext(first);//构成环形
                curBoy=first;
            }else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy=boy;
            }
        }

    }

    //遍历当前的环形链表
    public void showBoy(){
        //判断链表是否为空
        if(first==null){
            System.out.println("没有任何小孩~~~");
            return;
        }
        Boy curBoy = first;
        while (true){
            System.out.printf("小孩的编号%d\n",curBoy.getNo());
            if(curBoy.getNext()==first){//说明已经遍历完毕
                break;
            }
            curBoy = curBoy.getNext();



        }
    }


    /**
     * 根据用户的输入，计算出小孩出圈的顺序
     * @param startNo 表示从第几个小孩开始报数
     * @param countNum 表示数几下
     * @param nums 表示最初有多少个小孩在圈中
     */
    public void countBoy(int startNo,int countNum,int nums){
        //先对数据进行校验
        if(first==null||startNo<1||startNo>nums){
            System.out.println("输入数据有误，请重新输入");
        }
        //新建helper指针,帮助完成小孩出圈
        Boy helper = first;
        //需求创建一个辅助指针（变量）helper,事先应指向环形链表的最后这个节点
        while (true){
            if(helper.getNext()==first){//说明helper指向最后小孩节点
                break;
            }
            helper = helper.getNext();
        }
        //根据startNo创建first指针
        for (int i = 1; i <startNo ; i++) {
            first = first.getNext();
            helper=helper.getNext();
        }

        //helper和first指针已到位，可以开始小孩出圈工作
        while (true){

            if(helper==first){//说明圈中只有一个人，直接输出
                System.out.printf("最后一个小孩%d出圈\n",first.getNo());
                break;
            }
            for (int i = 1; i <countNum; i++) {
                first = first.getNext();
                helper=helper.getNext();
            }
            //这时first指向的节点，就是要出圈的小孩节点
            System.out.printf("小孩%d出圈\n",first.getNo());
            //这时将first指向的小孩节点出圈
                first=first.getNext();
                helper.setNext(first);

        }

    }
}

//创建一个Boy类，表示一个节点
class Boy{

      private int no;//编号
      private Boy next;//指向一个节点，默认是null
      public Boy(int no){
          this.no=no;
      }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "no=" + no +
                ", next=" + next +
                '}';
    }
}
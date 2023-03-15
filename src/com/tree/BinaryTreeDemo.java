package com.tree;

public class BinaryTreeDemo {

    public static void main(String[] args) {

    }


}


//定义二叉树
class BinaryTree{
    private HeroNode root;
    public void setRoot(HeroNode root){
        this.root=root;
    }

    //前序遍历
    public void preOrder(){
        if(this.root!=null){
            this.root.preOrder();
        }
    }

    //中序遍历
    public void midOrder(){
        if(this.root!=null){
            this.root.midOrder();
        }
    }

    //后序遍历
    public void postOrder(){
        if(this.root!=null){
            this.root.postOrder();
        }
    }


}



//创建节点
class HeroNode{
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    public HeroNode(int no,String name){
        super();
        this.no=no;
        this.name=name;

    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    //编写前序遍历的方法
    public void preOrder(){
        System.out.println(this);//先输出父节点
        if(this.left!=null){
            this.left.preOrder();//先序遍历左子树
        }
        if(this.right!=null){
            this.right.preOrder();//遍历右子树
        }
    }

    //编写中序遍历的方法

    public void midOrder(){
        if(this.left!=null){
            this.left.midOrder();
        }

        System.out.println(this);

        if (this.right!=null){
            this.right.midOrder();
        }


    }

    //编写后序遍历的方法
    public void postOrder(){
        if(this.left!=null){
            this.left.postOrder();//先序遍历左子树
        }
        if(this.right!=null){
            this.right.postOrder();//遍历右子树
        }

        System.out.println(this);
    }
}

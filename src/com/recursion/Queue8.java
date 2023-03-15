package com.recursion;

public class Queue8 {

        private int max = 12;
        private int[] array = new int[max];
        private int count = 0;

        //编写一个方法，放置在第n个皇后
        //特别注意：check是每一次递归时，进入到check中都有for(int i=0;i<max;i++),因此会有回溯
        public void check(int n){
            if(n==max){
                print();
                return;
            }
            //依次放入皇后，并判断冲突
            for (int i = 0; i < max; i++) {
                //先把当前的皇后n，放到该行的第一列
                array[n]=i;
                //判断当前放置第n个皇后i列时，是否冲突
                if (judge(n)){//不冲突
                    //接着放n+1个皇后，即开始递归
                    check(n+1);
                }
                //如果冲突，就继续执行array[n]=i;即将第n个皇后，放置在本行得后移得一个位置
            }

        }


        //判断是否有冲突
    public boolean judge(int n){
        for (int i = 0; i < n; i++) {
            if(array[n]==array[i]||Math.abs(n-i)==Math.abs(array[n]-array[i])){
                return false;
            }
        }
        return true;
    }

        //用来打印每次成功的结果
        public void print(){
            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i]+"");
            }
            System.out.println();

        }



}
class Queue8Demo{
    public static void main(String[] args) {
        Queue8 queue8 = new Queue8();
        queue8.check(0);
    }
}
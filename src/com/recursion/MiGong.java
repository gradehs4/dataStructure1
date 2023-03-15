package com.recursion;

public class MiGong {
    public static void main(String[] args) {
        //1. 先创建地图
        //1.1 创建一个二位数组
        int[][] map = new int[8][7];
        //使用1表示墙
        for (int i = 0; i < 7; i++) {
            map[0][i]=1;
            map[7][i]=1;
        }
        for (int i = 0; i < 8; i++) {
            map[i][0]=1;
            map[i][6]=1;
        }

        map[3][1]=1;//设置墙体
        map[3][2]=1;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
        //2.使用递归回溯给小球找路
        setWay(map,1,1);

        //输出新的地图，小球走过，并标识过的递归
        System.out.println("地图情况");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }



    }
//    使用递归回溯来给小球找路
//    说明
//    map 表示地图
//    i,j 表示从地图的哪个位置开始出发(1,1)
    //如果小球能到map[6][5]位置，则说明通路找到
    //约定：如果map[i][j]为0表示该点没有走过 当为1表示墙；2表示通路可以走；3表示该点已经走过，但是走不通
    //在走迷宫时，需要确定一个策略 下->右->上->左，如果该点走不同，在回溯

    /**
     *
     * @param map 表示地图
     * @param i 从哪个位置开始找
     * @param j
     * @return 如果找到通路，就返回true,否则返回false
     */
    public static boolean setWay(int[][] map,int i,int j){
        if(map[6][5]==2){//通路已经找到
            return true;
        }else {
           if(map[i][j]==0){
               //按照策略 下->右->上->左 走
               map[i][j]=2;//假设这个点可以走通
               if(setWay(map,i+1,j)){//向下走
                   return true;
               }else if (setWay(map,i,j+1)){//向右走
                   return true;
               }else if(setWay(map,i-1,j)){//向上
                   return true;
               }else if (setWay(map,i,j-1)){//向左走
                   return true;
               }else {
                   //说明该点是走不通，是死路
                   map[i][j]=3;
                   return false;
               }
           } else {//如果map[i][j]!=0,可能是1，2，3
               return false;
           }
        }

    }

}

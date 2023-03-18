package com.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class quickDemo {
    private ArrayList<String> vertexList;//存储顶点
    private int[][] edges; //存储图对应的邻接矩阵
    private int numOfEdges; //表示边数
    private boolean[] isVisited;

    public static void main(String[] args) {

        //测试图
        int n =5; //结点个数
        String vertexs[]={"a","b","c","d","e"};
        //创建图

        //添加顶点
        quickDemo quickDemo = new quickDemo(5);
        for (String value:vertexs) {
            quickDemo.insertVertext(value);
        }

        //添加边
        quickDemo.insertEdge(0,1,1);
        quickDemo.insertEdge(0,2,1);
        quickDemo.insertEdge(1,2,1);
        quickDemo.insertEdge(1,3,1);
        quickDemo.insertEdge(1,4,1);

        //显示邻接矩阵
        quickDemo.showGraph();


        //测试，dfs遍历是否成功
//        System.out.println("深度遍历");
//        quickDemo.dfs();

        //测试，bfs遍历是否成功
        System.out.println("广度遍历");
        quickDemo.bfs();


    }


    //创建构造器
    public quickDemo(int n){
        //初始化矩阵和vertextList
        edges=new int[n][n];
        vertexList = new ArrayList<String>(n);
        numOfEdges=0;
        isVisited=new boolean[n];
    }


    //得到第一个邻接节点的下标
    public int getFirstNeighbor(int index){
        for (int i = 0; i < vertexList.size(); i++) {
            if (edges[index][i]>0){  //很精妙
                return i;
            }
        }
        return -1;
    }

    //当表示当前节点已经访问过了，需要找下一个节点（v1,v2既是元素的下标，又是矩阵的横纵坐标）
    public int getNextNeighbor(int v1,int v2){
        for (int i = v2+1; i < vertexList.size(); i++) {
            if (edges[v1][i]>0){
                return i;
            }
        }
        return -1;
    }


    //bfs算法
    //对一个节点进行广度优先遍历
    private void bfs(boolean[] isVisited,int i){
        int u;//表示头结点对应的小标
        int w;//邻接结点w
        //队列，记录节点访问的顺序
        LinkedList queue = new LinkedList();
        //访问节点，输出信息
        System.out.printf(getIndexVertex(i)+"=>");
        isVisited[i]=true;

        queue.addLast(i);

        while (!queue.isEmpty()){
            u=(Integer)queue.removeFirst();
            //得到第一个邻接结点的下标w
            w=getFirstNeighbor(u);
            while (w!=-1){
                if (!isVisited[w]){
                    System.out.println(getIndexVertex(w)+"=>");
                    //标记已经访问
                    isVisited[w]=true;
                    //入队
                    queue.addLast(w);
                }

                w = getNextNeighbor(u,w);
            }
        }


    }

    //遍历所有结点，都进行广度优先搜索
    public void bfs(){
        for (int i = 0; i < getNumOfVertex(); i++) {
            if(!isVisited[i]){
                bfs(isVisited,i);
            }
        }
    }




    //深度优先遍历算法
    //i第一次就是0
    private void dfs(boolean[] isVisited,int i){
          //首先我们访问该节点，输出
        System.out.printf(getIndexVertex(i)+"->");
        //将节点设置为已访问
        isVisited[i]=true;
        //查找节点v的第一个邻接节点
        int w = getFirstNeighbor(i);
        while (w!=-1){
            if(!isVisited[w]){
                dfs(isVisited,w);
            }else{
                w = getNextNeighbor(i,w);
            }
        }


    }

    //对DFS进行一个重载，遍历我们所有的节点，并进行dfs

    public void dfs(){
        //遍历所有的节点，进行dfs[回溯]
        for (int i = 0; i <getNumOfVertex() ; i++) {
            if(!isVisited[i]){
                dfs(isVisited,i);
            }

        }
    }
    


    //插入顶点值
    public void insertVertext(String vertext){
        vertexList.add(vertext);
    }

    //添加边
    public void insertEdge(int v1,int v2,int value){
        edges[v1][v2]=value;
        edges[v2][v1]=value;
        numOfEdges++;
    }

    //图中常用的方法
       //返回顶点的个数
    public int getNumOfVertex(){
        return vertexList.size();
    }

      //返回边的个数
    public int getNumOfEdges(){
        return numOfEdges;
    }

      //根据下标返回顶点值
    public String getIndexVertex(int i){
        return vertexList.get(i);
    }

      //返回v1和v2的权值

    public int getValue(int i,int j){
        return edges[i][j];
    }

      //显示图对应的矩阵
    public void showGraph(){
        for (int[] link: edges) {
            System.out.println(Arrays.toString(link));
        }
    }

}

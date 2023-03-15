package com.queue;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SparseArray {
    public static void main(String[] args) throws IOException {
       int[][] chessArr1= new int[11][11];
        int sum = 0;
        int count=0;
       chessArr1[1][2]=1;
       chessArr1[2][3]=2;

       //输出原始的二维数组

        for (int[] ints : chessArr1) {

          for (int anInt : ints) {
           //System.out.printf("%d\t",anInt);
                 if(anInt!=0){
                        sum++;
                  }
             }
           // System.out.println();
        }

        System.out.println("sum="+sum);

        //2.创建对应的稀疏矩阵
        int sparseArr[][]=new int[sum+1][3];
        sparseArr[0][0]=11;
        sparseArr[0][1]=11;
        sparseArr[0][2]=sum;

        //3.给稀疏数组幅值
        for (int i =0;i<11;i++){
            for (int j=0;j<11;j++){
                if(chessArr1[i][j] !=0){
                  count++;
                  sparseArr[count][0]=i;
                  sparseArr[count][1]=j;
                  sparseArr[count][2]=chessArr1[i][j];
                }
            }

        }

        //输出得到稀疏数组
        System.out.println("得到的稀疏数组为~~~~");
        for (int i = 0; i < sparseArr.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n",sparseArr[i][0],sparseArr[i][1],sparseArr[i][2]);

        }

        saveArray(sparseArr);
//        FileOutputStream fos = new FileOutputStream(new File("oo.txt"));
//        for (int i = 0; i < sum+1; i++) {
//            for (int j = 0; j < 3; j++) {
//                fos.write(sparseArr[i][j]+"\t");
//            }
//            fos.write("\r\n".getBytes());
//        }
//        fos.close();

        int[][] ints1 = readArray();

        //将稀疏数组恢复到原来的数组
        //1.恢复原来数组的（无值）
        int chessArr2[][]=new int[ints1[0][0]][ints1[0][1]];
        //2.将值复原
        for (int i = 1; i < ints1.length; i++) {
            chessArr2[ints1[i][0]][ints1[i][1]]=ints1[i][2];
        }

        //恢复后是数组展示
        System.out.println("恢复后的数组展示---------");
        for (int[] ints : chessArr2) {

            for (int anInt : ints) {
                System.out.printf("%d\t",anInt);
            }
               System.out.println();
        }
    }

    /**
     *将二位数组存入txt文本
     * @param array
     */
    public static void saveArray(int[][] array){
        //1.创建字符输出流
        FileWriter writeFile = null;
        try {
            //2.数据想写入的路径及文件
            File file = new File("Array.txt");
            //3.如果该文件不存在，就创建
            if(!file.exists()) {
                file.createNewFile();
            }
            //4.给字节输出流赋予实例
            writeFile = new FileWriter(file);
            //5.通过循环将数组写入txt文件中
            for(int i = 0; i < array.length; i++) {
                //6.数据前n - 1列尾部加入","
                for(int j = 0; j < array[0].length - 1; j++) {
                    writeFile.write(array[i][j] + ",");
                }
                //7.数组最后一列后面不加","
                writeFile.write(array[i][array[0].length - 1] + "");
                //8.加上换行符
                writeFile.write("\n");
            }
            //9.把writeFile里的数据全部刷新一次，全部写入文件中
            writeFile.flush();
        } catch (Exception e) {//10.异常捕获
            e.printStackTrace();
        } finally {
            try {
                //11.如果writeFile不为空，就将其关闭
                if(writeFile != null)
                    writeFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 从txt文本中读取二维数组
     * @return
     */
    public static int[][] readArray() {
        //1.声明一个字符输入流
        FileReader reader = null;
        //2.声明一个字符输入缓冲流
        BufferedReader readerBuf = null;
        //3.声明一个二维数组
        int[][] array = null;
        try {
            //4.指定reader的读取路径
            reader = new FileReader("Array.txt");
            //5.通过BufferedReader包装字符输入流
            readerBuf = new BufferedReader(reader);
            //6.创建一个集合，用来存放读取的文件的数据
            List<String> strList = new ArrayList<>();
            //7.用来存放一行的数据
            String lineStr;
            //8.逐行读取txt文件中的内容
            while((lineStr = readerBuf.readLine()) != null) {
                //9.把读取的行添加到list中
                strList.add(lineStr);
            }
            //10.获取文件有多少行
            int lineNum = strList.size();
            //11.获取数组有多少列
            String s =  strList.get(0);
            int columnNum = s.split("\\,").length;
            //12.根据文件行数创建对应的数组
            array = new int[strList.size()][columnNum];
            //13.记录输出当前行
            int count = 0;
            //14.循环遍历集合，将集合中的数据放入数组中
            for(String str : strList) {
                //15.将读取的str按照","分割，用字符串数组来接收
                String[] strs = str.split("\\,");
                for(int i = 0; i < columnNum; i++) {
                    array[count][i] = Integer.valueOf(strs[i]);
                }
                //16.将行数 + 1
                count++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //17.关闭字符输入流
            try {
                if(reader != null)
                    reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            //18.关闭字符输入缓冲流
            try {
                if(readerBuf != null)
                    readerBuf.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //19.返回稀疏数组
        return array;
    }
}

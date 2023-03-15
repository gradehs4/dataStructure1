package com.sort;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {8,9,1,7,2,3,5,4,6,0};
        // shellSort(arr);
        shellSort2(arr);
    }

    //使用逐步推导的方式来编写希尔排序(交换希尔排序，速度会变慢)
    public static void shellSort(int[] arr){
        //希尔排序的第1轮排序
        //因为是第一轮排序，是将10个数据分成5组
        int temp=0;
        for (int gap = arr.length/2; gap >0 ; gap/=2) {
            for (int i = gap; i < arr.length ; i++) {
                //遍历各组中的所有的元素(共5组，每组有2个元素)，步长5
                for (int j = i-gap; j >=0; j-=gap){
                    //如果当前元素大于加上步长后的那个元素，说明交换
                    if(arr[j]>arr[j+gap]){
                        temp=arr[j];
                        arr[j]=arr[j+gap];
                        arr[j+gap]=temp;
                    }
                }
            }
            System.out.println(Arrays.toString(arr));
        }
    }
    //希尔排序使用位移法
    public static void shellSort2(int[] arr){
        int temp=0;
        for (int gap = arr.length/2; gap >0 ; gap/=2) {
            //从第gap个元素，逐个对其所在的组进行直接插入排序
            for (int i =gap; i <arr.length ; i++) {
                int j=i;
                temp = arr[j];
                if(arr[j]<arr[j-gap]){
                    while (j-gap >=0 && temp<arr[j-gap]){
                        //移动
                        arr[j]=arr[j-gap];
                        j-=gap;
                    }
                    arr[j]=temp;
                }
            }
            System.out.println(Arrays.toString(arr));
        }

    }
}

package com.sort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int arr[] = {3,9,-1,10,20};
        int temp=0;
        boolean flag=false;
        for (int i = 0; i < arr.length-1; i++) {

            for (int j = 0; j < arr.length-1-i; j++) {
              if(arr[j]>arr[j+1]) {
                  flag=true;
                  temp = arr[j];
                  arr[j] = arr[j + 1];
                  arr[j + 1] = temp;
              }
            }
            System.out.println("第"+(i+1)+"趟排序后得数组");
            System.out.println(Arrays.toString(arr));
            if(!flag){
                return;
            }else {
                flag=false;//重置flag!!!进行下次判断
            }
        }
    }
}

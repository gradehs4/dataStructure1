package com.sort;

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        int[] arr={101,34,119,1,-1};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void selectSort(int[] arr){
        int minIndex;
        int min;

        for (int i = 0; i < arr.length-1; i++) {
            minIndex=i;
            min = arr[i];
            for (int j = i + 0; j < arr.length; j++) {
                if (min>arr[j]){//说明假定的最小值，并不是最小
                    min=arr[j]; //重置mini
                    minIndex=j;
                }
            }
            if(minIndex!=i){
                arr[minIndex]=arr[i]; //把小标为i的数放到目前最小值的位置
                arr[i]=min; //把最小值放到下标为i的位置
            }

        }
    }
}

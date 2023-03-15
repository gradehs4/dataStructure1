package com.recursion;

public class RecursionTest {
    public static void main(String[] args) {

        test(8);
        int factorial = factorial(4);
        System.out.println(factorial);

    }
//   打印结果为n=2
//    public static void test(int n){
//        if(n>2){
//            test(n-1);
//        }else {
//            System.out.println("n=" + n);
//        }
//    }

    //打印结果为n=2,3,4,5....
    public static void test(int n){
        if(n>2){
            test(n-1);
        }
            System.out.println("n=" + n);
    }

    //阶乘问题
    public static int factorial(int n){
        if(n==1){
            return 1;
        }else {
            return factorial(n-1)*n;
        }
    }
}

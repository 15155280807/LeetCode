package com.example.demo;

/**
 * @author jl.yao
 * @className BitOperation
 * @description 位运算
 * @date 2021/6/25 9:07
 **/
public class BitOperation {
    public static void main(String[] args) {
        int[] arr = {1,1,1,2,2,3,3,4,4,5,5};
        int[] arr2 = {1,1,1,2,2,3,3,4,4,5,5,5};
        printOddTimesNum(arr);
        printOddTimesNum2(arr2);
    }

    /**
     * 从一个数组中找出唯一一个奇数的数 时间O(N) 空间O(1)
     * @param arr
     */
    public static void printOddTimesNum(int[] arr){
        int eor = 0;
        for (int i : arr) {
            eor ^= i;
        }
        System.out.println("数组中唯一一个奇数： eor="+eor);
    }

    /**
     * 从一个数组中找出两个一个奇数的数 时间O(N) 空间O(1)
     * @param arr
     */
    public static void printOddTimesNum2(int[] arr){
        int eor = 0;
        for (int i : arr) {
            eor ^= i;
        }
        //eor = a ^ b
        //eor != 0
        //eor必然有一个位置上为1
        int onlyOne =0;
        //找到eor 最右侧的 1
        int rightOne= eor & (~eor +1);

        for (int i : arr) {
            int j = i & rightOne;
            System.out.println("j="+j);
            if (j == rightOne){
                onlyOne ^= i;
            }
        }

        System.out.println("数组中两个奇数： onlyOne="+onlyOne+";"+"eor="+(eor^onlyOne));
    }
}

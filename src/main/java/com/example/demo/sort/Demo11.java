package com.example.demo.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author jl.yao
 * @className Demo11
 * @description 面试题 10.01. 合并排序的数组
 * @date 2021/11/17 16:07
 **/
public class Demo11 {


    /**
     * 给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。
     *
     * 初始化A 和 B 的元素数量分别为m 和 n。
     *
     * 示例:
     *
     * 输入:
     * A = [1,2,3,0,0,0], m = 3
     * B = [2,5,6],       n = 3
     *
     * 输出:[1,2,2,3,5,6]
     * 说明:
     *
     * A.length == n + m
     */
    @Test
    public void test(){
        int[] A = new int[]{1,2,3,0,0,0};
        int[] B = new int[]{2,5,6};
        merge2(A,3,B,3);
    }

    //拼接在A的后面
    public void merge(int[] A, int m, int[] B, int n) {
        for (int i = 0; i != n; ++i) {
            A[m + i] = B[i];
        }
        Arrays.sort(A);
    }

    //双指针
    public void merge2(int[] A, int m, int[] B, int n) {
        int indexA = 0;
        int indexB = 0;
        int index = 0;
        int[] result = new int[m + n];
        while (indexA < m || indexB < n){
            if (indexA == m){
                result[index++] = B[indexB++];
            }else if (indexB == n){
                result[index++] = A[indexA++];
            }else if (A[indexA] < B[indexB]){
                result[index++] = A[indexA++];
            }else {
                result[index++] = B[indexB++];
            }
        }
        for (int i = 0; i != m + n; ++i) {
            A[i] = result[i];
        }
    }

}

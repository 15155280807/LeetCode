package com.example.demo.sort;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author jl.yao
 * @className Demo01
 * @description
 * @date 2021/7/5 19:04
 **/
@Slf4j
public class Demo01 {

    /**
     * 需求：给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
     *
     * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
     * 输出：[1,2,2,3,5,6]
     * 示例 2：
     *
     * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
     * 输出：[1]
     *  
     *
     * 提示：
     *
     * nums1.length == m + n
     * nums2.length == n
     * 0 <= m, n <= 200
     * 1 <= m + n <= 200
     * -109 <= nums1[i], nums2[i] <= 109
     *
     */

    @Test
    public void test(){

        int[] arr = {1,7,3,2,5,4};
        int[] bubble = choiceMax(arr);
        System.out.println(bubble);
    }

    //方法一 利用数组排序
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i != n; ++i) {
            nums1[m + i] = nums2[i];
        }
        Arrays.sort(nums1);
    }

    //方法二双指针 利用数组排序
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        //先合并至一个数组
        for (int i = 0; i != n; ++i) {
            nums1[m + i] = nums2[i];
        }
        bubble(nums1);
    }


    //方法二 冒泡排序
    public int[] bubble(int[] arr) {
        //n-1轮遍历
        for (int i = 1; i <arr.length; i++) {
            //每轮两两比较
            for (int j = 0; j < arr.length-i; j++) {
                if (arr[j] > arr[j+1]){
                    swap(arr,j,j+1);
                }
            }
        }
        return arr;
    }

    //方法二 选择(选择最小的)
    public int[] choiceMin(int[]  arr) {
        //n-1轮遍历
        for (int i = 0; i <arr.length-1; i++) {
            //每轮选择一个最小的
            int min = i;
            for (int j = i+1; j < arr.length; j++) {
              if (arr[j] < arr[min]){
                  min = j;
              }
              if (i != min){
                  //交换
                  swap(arr,i,min);
              }
            }
        }
        return arr;
    }

    //方法二 选择(选择最大的)
    public int[] choiceMax(int[]  arr) {
        //n-1轮遍历
        for (int i = arr.length-1; i >0; i--) {
            int max = i;
            //每轮选择一个最大的
            for (int j = 0; j <= i; j++) {
                if (arr[j] > arr[max]){
                    max = j;
                }
                if (i != max){
                    //交换
                    swap(arr,i,max);
                }
            }
        }
        return arr;
    }


    //方法三 插入
    public int[] insert(int[]  arr) {


        return arr;
    }

    public void swap(int[] arr,int l,int f){
        int tmp = arr[l];
        arr[l] = arr[f];
        arr[f] = tmp;
    }


}

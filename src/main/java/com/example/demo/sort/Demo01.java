package com.example.demo.sort;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;

/**
 * @Auther: yjl
 * @Date: 2021/7/5 21:05
 * @since: jdk1.8
 * @Description: 合并两个有序数组
 */
@Slf4j
public class Demo01 {


    /**
     * 需求：给你两个有序整数数组nums1 和 nums2，请你将 nums2 合并到nums1中，使 nums1 成为一个有序数组。
     *
     * 初始化nums1 和 nums2 的元素数量分别为m 和 n 。你可以假设nums1 的空间大小等于m + n，这样它就有足够的空间保存来自 nums2 的元素。
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
     */


    @Test
    public void test(){

        int[] arr = {6,5,4,0,0,0};
        int[] arr2 = {3,2,1};
//        int[] bubble = insertDesc(arr);
        int[] bubble = ReverseDoublePoint(arr,3,arr2,3);
        for (int i : bubble) {
            System.out.print(i);
        }
    }
//    方法一 利用Arrays数组排序
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i<n ; i++) {
            nums1[m+i] =nums2[i];
        }
        Arrays.sort(nums1);


    }

    //    方法二 冒泡排序
    public int[] bubble(int[] arr) {

        //n-1轮遍历
        for (int i = 1; i < arr.length; i++) {

            for (int j = 0; j <arr.length-i ; j++) {
                if (arr[j] > arr[j+1]){
                    swap(arr,j,j+1);
                }
            }
        }
        return arr;
    }

    //    方法三 选择排序选择最小的
    public int[] choiceMin(int[] arr) {

        //n-1轮遍历
        for (int i = 0; i < arr.length-1; i++) {
            int min = i;
            for (int j = i + 1; j <arr.length ; j++) {
                if (arr[j] < arr[min]){
                    min = j;
                }

            }
            if (i!=min){
                swap(arr,i,min);
            }
        }
        return arr;
    }

    //    方法三 选择排序 选择最大的
    public int[] choiceMax(int[] arr) {

        //n-1轮遍历
        for (int i = arr.length-1; i>=0; i--) {
            int max = i;
            for (int j = 0; j < i ; j++) {
                if (arr[j] > arr[max]){
                    max = j;
                }

            }
            if (i!=max){
                swap(arr,i,max);
            }
        }
        return arr;
    }

    //方法四 插入排序(正序)
    public int[] insertAsc(int[] arr) {
        for (int i = 0; i < arr.length ; i++) {
            //当前为带插入数
            int tmp = arr[i];
            int j = i;

            //从右至左找到需要插入的点，小于就交换数据，索引-- 一次对比
            while (j > 0 && tmp < arr[j-1]){
                //交换
                arr[j] = arr[j-1];
                j--;
            }
            //找到插入点
            arr[j]=tmp;
        }
        return arr;
    }

    //方法四 插入排序(倒序)
    public int[] insertDesc(int[] arr) {
        for (int i = 0; i < arr.length ; i++) {
            //当前为带插入数
            int tmp = arr[i];
            int j = i;

            //从右至左找到需要插入的点，小于就交换数据，索引-- 一次对比
            while (j > 0 && tmp > arr[j-1]){
                //交换
                arr[j] = arr[j-1];
                j--;
            }
            //找到插入点
            arr[j]=tmp;
        }
        return arr;
    }


    //方法五 双指针
    public int[] doublePoint(int[] nums1, int m, int[] nums2, int n) {

        int p1 = 0;
        int p2 = 0;
        int cur = 0;
        int[] sort =new int[m+n];
        while (p1 < m || p2< n){
            if (p1 == m){
                cur = nums2[p2++];
            }else
            if (p2 == n){
                cur = nums1[p1++];
            }else
            if (nums1[p1] > nums2[p2]){
                cur = nums2[p2++];
            }else {
                cur = nums1[p1++];
            }

            sort[p1 + p2 - 1] = cur;
        }
        for (int i = 0; i != m + n; ++i) {
            nums1[i] = sort[i];
        }
        return nums1;
    }

    //方法六 逆序双指针
    public int[] ReverseDoublePoint(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1;
        int tail = m + n - 1;
        int cur;
        while (p1 >= 0 || p2 >= 0) {
            if (p1 == -1) {
                cur = nums2[p2--];
            } else if (p2 == -1) {
                cur = nums1[p1--];
            } else if (nums1[p1] > nums2[p2]) {
                cur = nums1[p1--];
            } else {
                cur = nums2[p2--];
            }
            nums1[tail--] = cur;
        }
        return nums1;
    }
    public void swap(int[] arr,int l ,int f){
        int tmp= arr[l];
        arr[l]=arr[f];
        arr[f]=tmp;
    }

}

package com.example.demo.sort;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;

/**
 * @Auther: yjl
 * @Date: 2021/7/1 22:27
 * @since: jdk1.8
 * @Description: 快速排序
 */
@Slf4j
public class quickSort {


    @Test
    public void test(){
        int[] arr = {1,1,2,3,6,8,8,7,5,3,3,2,0,0,8,8,5,4,2,7,3};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }


    //经典快排
    public static void quickSort(int[] arr,int left ,int right ){
       if (left < right ){
           //从数组中随机一位与最右侧交换，作为标志位，大于放左侧 小于放右侧
           swap(arr,left+(int)(Math.random() *(right-left+1)),right);
           //划分出左侧和右侧的边界，该边界数组只有两位【左边界，有边界】，此边界中数据都与标志位数据相同，即已排好序
           int[] p = partition(arr,left,right);
           //左边界重复排序
           quickSort(arr,left,p[0]-1);
           //右边界重复排序
           quickSort(arr,p[1]+1,right);
       }

    }

    public static void swap(int[] arr,int left ,int right){
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }

    public static int[] partition(int[] arr,int left ,int right){
        //小于区右边界，初始化0是右边界则为 -1
        int less = left-1;
        // 大于区 左边界 初始化是为最右侧
        int more = right;
        //当小于区右边界小于大于区左边界时 比较数据 交换
        while (left < more){
            //当小于区右边界向右扩展，将小于区右边界下一位与标志位比较
            if (arr[left] < arr[right]){
                //小于标志位，右边界向右扩展，
                swap(arr,++less,left++);
            }else if (arr[left] > arr[right]){
                //大于标志位，大于区左边界向左扩展
                swap(arr,--more,left);
            }else {
                left++;
            }
        }
        swap(arr,more,right);
        return new int[]{less+1,more};
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i<n ; i++) {
            nums1[m+i] =nums2[i];
        }
        Arrays.sort(nums1);
    }


    //归并排序

    @Test
    public void f(){
        int[] arr =new int[]{3,1,2,9,4,7,8,6,5,0};
       int[] helpArr= new int[arr.length];
        sort(arr,0,arr.length-1,helpArr);
        System.out.println(Arrays.toString(arr));
    }

    public void sort(int[] arr,int left ,int right,int[] helpArr){
        if (left >= right){
            return;
        }
        int mid = left + (right - left) / 2;
        //左侧排序合并
        sort(arr,left,mid,helpArr);
        //右侧排序合并
        sort(arr,mid+1,right,helpArr);
        mergeSort(arr,left,mid,right,helpArr);
    }

    private void mergeSort(int[] arr, int left, int mid, int right, int[] helpArr) {
        //定义辅助数组的索引下标 l左侧数组第一个下标，r右侧数组第一个下标
        int l = left,r= mid+1, p = l;
        //左侧数组和右侧数组比较，谁小 谁先进去辅助数组
        while (l <= mid && r <= right){
            helpArr[p++] = arr[l] < arr[r] ? arr[l++]: arr[r++];
        }
        //左侧数组还有未排序数组 直接放入辅助数组
        while ( l<= mid){
            helpArr[p++] = arr[l++];
        }
        //右侧数组还有未排序数组 直接放入辅助数组
        while ( r <= right){
            helpArr[p++] = arr[r++];
        }
        //所有数组完成排序 ，再讲辅助数组中的数据复制到原数组
        for (int i = left; i <= right; i++) {
            arr[i] = helpArr[i];
        }

    }


}

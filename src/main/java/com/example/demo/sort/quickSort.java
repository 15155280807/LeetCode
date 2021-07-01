package com.example.demo.sort;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

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
        int[] arr ={4,8,6,7,2,1,1,1,2,3,4,8,6,7,7,5};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(arr.toString());
    }


    //经典快排 1.0
    public static void quickSort(int[] arr){
        if (arr== null || arr.length <2){
            return ;
        }

    }
    public static void quickSort(int[] arr,int left ,int right ){
       if (left < right ){
           swap(arr,left+(int)(Math.random() *(right-left+1)),right);
           int[] p = partition(arr,left,right);
           quickSort(arr,left,p[0]-1);
           quickSort(arr,p[1]+1,right);
       }

    }

    public static void swap(int[] arr,int left ,int right){
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }

    public static int[] partition(int[] arr,int left ,int right){
        //<区右边界
        int less = left-1;
        // >区 左边界
        int more = right;
        while (left < more){
            if (arr[left] < arr[right]){
                swap(arr,++less,left++);
            }else if (arr[left] > arr[right]){
                swap(arr,--more,left);
            }else {
                left++;
            }
        }
        swap(arr,more,right);
        return new int[]{less+1,more};
    }

}

package com.example.demo.sort;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Random;

*
 * @Auther: yjl
 * @Date: 2021/7/1 21:52
 * @since: jdk1.8
 * @Description: 早餐组合


@Slf4j
public class Demo01 {


*
     * 需求：
     * 小扣在秋日市集选择了一家早餐摊位，一维整型数组 staple 中记录了每种主食的价格，
     * 一维整型数组 drinks 中记录了每种饮料的价格。小扣的计划选择一份主食和一款饮料，且花费不超过 x 元。请返回小扣共有多少种购买方案。
     *
     * 注意：答案需要以 1e9 + 7 (1000000007) 为底取模，如：计算初始结果为：1000000008，请返回 1
     *
     * 示例 1：
     *
     * 输入：staple = [10,20,5], drinks = [5,5,2], x = 15
     *
     * 输出：6
     *
     * 解释：小扣有 6 种购买方案，所选主食与所选饮料在数组中对应的下标分别是：
     * 第 1 种方案：staple[0] + drinks[0] = 10 + 5 = 15；
     * 第 2 种方案：staple[0] + drinks[1] = 10 + 5 = 15；
     * 第 3 种方案：staple[0] + drinks[2] = 10 + 2 = 12；
     * 第 4 种方案：staple[2] + drinks[0] = 5 + 5 = 10；
     * 第 5 种方案：staple[2] + drinks[1] = 5 + 5 = 10；
     * 第 6 种方案：staple[2] + drinks[2] = 5 + 2 = 7。
     *
     * 示例 2：
     *
     * 输入：staple = [2,1,1], drinks = [8,9,5,1], x = 9
     *
     * 输出：8
     *
     * 解释：小扣有 8 种购买方案，所选主食与所选饮料在数组中对应的下标分别是：
     * 第 1 种方案：staple[0] + drinks[2] = 2 + 5 = 7；
     * 第 2 种方案：staple[0] + drinks[3] = 2 + 1 = 3；
     * 第 3 种方案：staple[1] + drinks[0] = 1 + 8 = 9；
     * 第 4 种方案：staple[1] + drinks[2] = 1 + 5 = 6；
     * 第 5 种方案：staple[1] + drinks[3] = 1 + 1 = 2；
     * 第 6 种方案：staple[2] + drinks[0] = 1 + 8 = 9；
     * 第 7 种方案：staple[2] + drinks[2] = 1 + 5 = 6；
     * 第 8 种方案：staple[2] + drinks[3] = 1 + 1 = 2；
     *
     * 提示：
     *
     * 1 <= staple.length <= 10^5
     * 1 <= drinks.length <= 10^5
     * 1 <= staple[i],drinks[i] <= 10^5
     * 1 <= x <= 2*10^5
     *



    @Test
    public void test(){

    }


    //方法一 先排序
    public int breakfastNumber(int[] staple, int[] drinks, int x) {
        if (staple.length ==0){

        }
        quickSort(staple,0,staple.length-1);
        quickSort(drinks,0,drinks.length-1);



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

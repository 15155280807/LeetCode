package com.example.demo.day02;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author jl.yao
 * @className Demo
 * @description 977. 有序数组的平方
 * @date 2021/11/01 18:59
 **/
public class Demo01 {

    @Test
    public void test(){
    }

    /**
     * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：nums = [-4,-1,0,3,10]
     * 输出：[0,1,9,16,100]
     * 解释：平方后，数组变为 [16,1,0,9,100]
     * 排序后，数组变为 [0,1,9,16,100]
     * 示例 2：
     *
     * 输入：nums = [-7,-3,2,3,11]
     * 输出：[4,9,9,49,121]
     *  
     *
     * 提示：
     *
     * 1 <= nums.length <= 104
     * -104 <= nums[i] <= 104
     * nums 已按 非递减顺序 排序
     *  
     *
     * 进阶：
     *
     * 请你设计时间复杂度为 O(n) 的算法解决本问题
     *
     * @param nums
     * @return
     */
    //直接排序
    public int[] sortedSquares(int[] nums) {
        if (nums == null || nums.length <= 0){
            return nums;
        }
        int length = nums.length;
        int[] target = new int[length];
        for (int i = 0; i < length; i++) {
            target[i]= nums[i] * nums[i];
        }
        Arrays.sort(target);
        return target;

    }
    //双指针
    public int[] sortedSquares2(int[] nums) {
        if (nums == null || nums.length <= 0){
            return nums;
        }
        int length = nums.length;
        int[] target = new int[length];
        for (int i = 0, j = length -1,pos = length - 1; i<=j ;) {
           if (nums[i] * nums[i] < nums[j] * nums[j]){
               target[pos] = nums[j]* nums[j];
               --j;
           }else {
               target[pos] = nums[i]* nums[i];
               ++i;
           }
            --pos;
        }
        return target;

    }


}

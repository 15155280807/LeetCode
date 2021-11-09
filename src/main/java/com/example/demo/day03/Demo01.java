package com.example.demo.day03;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author jl.yao
 * @className Demo
 * @description 283. 移动零
 * @date 2021/11/01 18:59
 **/
public class Demo01 {

    @Test
    public void test(){
    }

    /**
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     *
     * 示例:
     *
     * 输入: [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     * 说明:
     *
     * 必须在原数组上操作，不能拷贝额外的数组。
     * 尽量减少操作次数。
     *
     * @param nums
     * @return
     */
    //双指针
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int l = 0 ;
        int r = 0 ;
        while (r<n){
            if (nums[r] != 0){
                swap(nums,r,l);
                l++;
            }
            r++;
        }

    }

    private void swap(int[] nums, int r, int l) {
        int tmp = nums[r];
        nums[r] = nums[l];
        nums[l] = tmp;
    }


}

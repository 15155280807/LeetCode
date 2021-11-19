package com.example.demo.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author jl.yao
 * @className Demo12
 * @description 面试题 17.04. 消失的数字
 * @date 2021/11/18 10:08
 **/
public class Demo12 {


    /**
     * 数组nums包含从0到n的所有整数，但其中缺了一个。请编写代码找出那个缺失的整数。你有办法在O(n)时间内完成吗？
     *
     * 注意：本题相对书上原题稍作改动
     *
     * 示例 1：
     *
     * 输入：[3,0,1]
     * 输出：2
     * 
     *
     * 示例 2：
     *
     * 输入：[9,6,4,2,3,5,7,0,1]
     * 输出：8
     *
     */
    @Test
    public void test(){

    }


    //位运算
    public int missingNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; ++i) {
            res ^= i;
            res ^= nums[i];
        }
        res ^= nums.length;
        return res;

    }
    //加法
    public int missingNumber2(int[] nums) {
        int sum=0;
        for(int x:nums){
            sum+=x;
        }
        return nums.length*(nums.length+1)/2-sum;

    }

}

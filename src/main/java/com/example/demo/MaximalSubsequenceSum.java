package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author jl.yao
 * @className MaximalSubsequenceSum
 * @description 最大子序和
 * @date 2021/3/22 15:48
 **/
@Slf4j
public class MaximalSubsequenceSum {

    /**
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
     * 输出：6
     * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
     * 示例 2：
     *
     * 输入：nums = [1]
     * 输出：1
     * 示例 3：
     *
     * 输入：nums = [0]
     * 输出：0
     * 示例 4：
     *
     * 输入：nums = [-1]
     * 输出：-1
     * 示例 5：
     *
     * 输入：nums = [-100000]
     * 输出：-100000
     *  
     *
     * 提示：
     *
     * 1 <= nums.length <= 3 * 104
     * -105 <= nums[i] <= 105
     *
     */
    @Test
    public void test(){

    }

    public int maxSubArray(int[] nums) {

        int pre = 0;
        int max = nums[0];
        for (int i : nums) {
          pre = Math.max(pre +i ,i);
          max = Math.max(max,pre);
        }

        for (int i = 0; i < nums.length-1; i++) {
            int sum = pre +nums[i];
            if (sum > i){
                pre = sum;
            }
            if (pre > max){
                max = pre;
            }
        }

        return max;
    }
}

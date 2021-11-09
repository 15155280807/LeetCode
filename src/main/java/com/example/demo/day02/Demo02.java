package com.example.demo.day02;

import org.junit.Test;

/**
 * @author jl.yao
 * @className Demo
 * @description 189. 旋转数组
 * @date 2021/11/01 18:59
 **/
public class Demo02 {

    @Test
    public void test(){
        rotate(new int[]{1,2,3,4,5,6,7},3);
    }

    /**
     *给定一个数组，将数组中的元素向右移动 k个位置，其中k是非负数。
     *
     *
     *
     * 进阶：
     *
     * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
     * 你可以使用空间复杂度为O(1) 的原地算法解决这个问题吗？
     *
     * 示例 1:
     *
     * 输入: nums = [1,2,3,4,5,6,7], k = 3
     * 输出: [5,6,7,1,2,3,4]
     * 解释:
     * 向右旋转 1 步: [7,1,2,3,4,5,6]
     * 向右旋转 2 步: [6,7,1,2,3,4,5]
     * 向右旋转 3 步: [5,6,7,1,2,3,4]
     * 示例2:
     *
     * 输入：nums = [-1,-100,3,99], k = 2
     * 输出：[3,99,-1,-100]
     * 解释:
     * 向右旋转 1 步: [99,-1,-100,3]
     * 向右旋转 2 步: [3,99,-1,-100]

     *
     * 提示：
     *
     * 1 <= nums.length <= 2 * 104
     * -231 <= nums[i] <= 231 - 1
     * 0 <= k <= 105
     */
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if ( n <= 1){
            return;
        }
        int[] tag = new int[n];
        for (int i = n -1; i >=0 ; i--) {
            int after = i + k;
            //右移后的坐标是否大于长度
            if (after > n -1){
                tag[after-n]=nums[i];
            }else {
                tag[after] = nums[i];
            }
        }
        System.arraycopy(tag, 0, nums, 0, n);
    }




}

package com.example.demo.sort;

import org.junit.Test;

/**
 * @author jl.yao
 * @className Demo14
 * @description 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 * @date 2021/11/19 11:18
 **/
public class Demo14 {


    /**
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。
     *
     * 示例：
     *
     * 输入：nums =[1,2,3,4]
     * 输出：[1,3,2,4]
     * 注：[3,1,2,4] 也是正确的答案之一。
     *
     * 提示：
     *
     * 0 <= nums.length <= 50000
     * 0 <= nums[i] <= 10000
     **/
    @Test
    public void test(){

    }

    /**
     * @param nums
     * @return
     */
    public int[] exchange(int[] nums) {
        int[] ints = new int[nums.length];
        int l =0;
        int r = nums.length-1;
        for (int num : nums) {
            if (num % 2 == 0){
                ints[r--] = num;
            }else {
                ints[l++] = num;
            }
        }
        return ints;
    }
    /**
     * 双指针(首尾指针，左侧查询出偶数。右侧查询数奇数交换)
     * @param nums
     * @return
     */
    public int[] exchange2(int[] nums) {
        int l = 0, r = nums.length-1;
        while (l<r){
            while (nums[l] % 2 != 0 && l < r){
                l++;
            }
            while (nums[r] % 2 == 0 && l < r){
                r--;
            }
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
        }

        return nums;
    }

    /**
     * 双指针(快慢指针)
     * @param nums
     * @return
     */
    public int[] exchange3(int[] nums) {
        int slow = 0,fast = 0;


        return nums;
    }

}

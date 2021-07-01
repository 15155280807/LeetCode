package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author jl.yao
 * @className SearchForInsertionLocation
 * @description 搜索插入位置
 * @date 2021/3/22 13:45
 **/
@Slf4j
public class SearchForInsertionLocation {

    /**
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     *
     * 你可以假设数组中无重复元素。
     *
     * 示例 1:
     *
     * 输入: [1,3,5,6], 5
     * 输出: 2
     *
     * 示例 2:
     * 输入: [1,3,5,6], 2
     * 输出: 1
     *
     * 示例 3:
     * 输入: [1,3,5,6], 7
     * 输出: 4
     *
     * 示例 4:
     * 输入: [1,3,5,6], 0
     * 输出: 0
     *
     */
    @Test
    public void test(){
        int[] nums = {1,3,5,6};
        int i = searchInsertThree(nums, 3);
        log.info("返回索引：{}",i);
    }

    /**
     * 遍历
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        //数组为空 或者 目标值小于等于数组第一位直接返回 0 索引
        if (nums.length == 0 || target <= nums[0]){
            return 0;
        }
        if ( target > nums[nums.length-1]){
            return nums.length;
        }
        for (int i = 0; i <nums.length ; i++) {
            if (nums[i] == target){
                return i;
            }
            if (nums[i] < target && nums[i+1] > target){
                return i+1;
            }
        }
        return 0;
    }


    /**
     * 官方位运算二分法
     * @param nums
     * @param target
     * @return
     */
    public int searchInsertTwo(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1, ans = n;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (target <= nums[mid]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
    /**
     * 除法运算二分法
     * @param nums
     * @param target
     * @return
     */
    public int searchInsertThree(int[] nums, int target) {
        /*int n = nums.length;
        int left = 0, right = n - 1, ans = n;
        while (left <= right) {
            int mid = (right - left)/2 + left;
            if (target <= nums[mid]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;*/
        int len = nums.length;
        if (len == 0) {
            return 0;
        }

        int left = 0;
        // 因为有可能数组的最后一个元素的位置的下一个是我们要找的，故右边界是 len
        int right = len;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 小于 target 的元素一定不是解
            if (nums[mid] < target) {
                // 下一轮搜索的区间是 [mid + 1, right]
                left = mid + 1;
            } else {
                // 下一轮搜索的区间是 [left, mid]
                right = mid;
            }
        }
        return left;

    }
}

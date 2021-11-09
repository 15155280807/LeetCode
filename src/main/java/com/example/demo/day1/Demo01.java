package com.example.demo.day1;

import org.junit.Test;

/**
 * @author jl.yao
 * @className Demo
 * @description
 * @date 2021/10/28 18:59
 **/
public class Demo01 {

    @Test
    public void test(){
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int search = search02(nums, 5);
        System.out.println(search);
    }

    /**
     * 二分查找
     * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
     *
     *
     * 示例 1:
     *
     * 输入: nums = [-1,0,3,5,9,12], target = 9
     * 输出: 4
     * 解释: 9 出现在 nums 中并且下标为 4
     * 示例 2:
     *
     * 输入: nums = [-1,0,3,5,9,12], target = 2
     * 输出: -1
     * 解释: 2 不存在 nums 中因此返回 -1
     *  
     *
     * 提示：
     *
     * 你可以假设 nums 中的所有元素是不重复的。
     * n 将在 [1, 10000]之间。
     * nums 的每个元素都将在 [-9999, 9999]之间。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/binary-search
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0){
            return -1;
        }
        int start = 0;
        int end = nums.length-1;
        while (start <= end){
            int mid = (end-start) / 2 + start;
            if (nums[mid] == target){
                return mid;
            }
            if (nums[mid] > target){
                end = mid-1;
            }else {
                start = mid+1;
            }
        }
        return -1;

    }

    /**
     * 二分查找
     * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
     *
     *
     * 示例 1:
     *
     * 输入: nums = [-1,0,3,5,9,12], target = 9
     * 输出: 4
     * 解释: 9 出现在 nums 中并且下标为 4
     * 示例 2:
     *
     * 输入: nums = [-1,0,3,5,9,12], target = 2
     * 输出: -1
     * 解释: 2 不存在 nums 中因此返回 -1
     *  
     *
     * 提示：
     *
     * 你可以假设 nums 中的所有元素是不重复的。
     * n 将在 [1, 10000]之间。
     * nums 的每个元素都将在 [-9999, 9999]之间。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/binary-search
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @param target
     * @return
     */
    public int search02(int[] nums, int target) {
        return searchTgt(nums,target,0,nums.length-1);
//        return search(nums, 0, nums.length - 1, target);
    }

    public int searchTgt(int[] nums,int target,int l ,int r){
       if (l > r){
           return -1;
       }
        int mid = l + (r-l) / 2;
        if (nums[mid] == target){
            return mid;
        }
        if (nums[mid] < target){
            searchTgt(nums,target,mid+1,r);
        }
        return searchTgt(nums,target,0,mid-1);
    }

    private int search(int[] nums, int l, int r, int target){
        //先判断递归终止条件
        if(l > r){
            return -1;
        }

        int mid = l + (r - l) / 2;
        if(nums[mid] == target){
            return mid;
        }
        if(nums[mid] < target){
            return search(nums, mid + 1, r, target);
        }
        return search(nums, 0, mid - 1, target);
    }


}

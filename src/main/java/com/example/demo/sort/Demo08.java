package com.example.demo.sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeSet;

/**
 * @author jl.yao
 * @className Demo08
 * @description 414. 第三大的数
 * @date 2021/11/17 10:35
 **/
public class Demo08 {

    /**
     *给你一个非空数组，返回此数组中 第三大的数 。如果不存在，则返回数组中最大的数。
     *
     * 示例 1：
     * 输入：[3, 2, 1]
     * 输出：1
     * 解释：第三大的数是 1 。
     * 示例 2：
     * 输入：[1, 2]
     * 输出：2
     * 解释：第三大的数不存在, 所以返回最大的数 2 。
     * 示例 3：
     * 输入：[2, 2, 3, 1]
     * 输出：1
     * 解释：注意，要求返回第三大的数，是指在所有不同数字中排第三大的数。
     * 此例中存在两个值为 2 的数，它们都排第二。在所有不同数字中排第三大的数为 1 。
     * 提示：
     *
     * 1 <= nums.length <= 104
     * -231 <= nums[i] <= 231 - 1
     */


    @Test
    public  void test(){
        thirdMax(new int[]{1,1,2});
    }



    public int thirdMax(int[] nums) {
        if (nums.length < 3){
            return nums[nums.length-1];
        }
        TreeSet<Integer> set = new TreeSet<>();
        for (Integer integer : nums) {
            set.add(integer);
        }
        int[] ints = set.stream().mapToInt(Integer::intValue).toArray();
        int length = ints.length;
        return length < 3?ints[length-1]:ints[length-3];
    }
}

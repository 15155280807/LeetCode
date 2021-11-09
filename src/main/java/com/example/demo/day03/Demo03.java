package com.example.demo.day03;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author jl.yao
 * @className Demo
 * @description 两个数组的交集 II
 * @date 2021/11/01 18:59
 **/
public class Demo03 {

    @Test
    public void test(){

    }

    /**
     * 给定两个数组，编写一个函数来计算它们的交集。
     *
     * 
     *
     * 示例 1：
     *
     * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
     * 输出：[2,2]
     * 示例 2:
     *
     * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     * 输出：[4,9]
     * 
     *
     * 说明：
     *
     * 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
     * 我们可以不考虑输出结果的顺序。
     * 进阶：
     *
     * 如果给定的数组已经排好序呢？你将如何优化你的算法？
     * 如果nums1的大小比nums2小很多，哪种方法更优？
     * 如果nums2的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？

     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int a = 0,b = 0,m =nums1.length,n=nums2.length;
        int[] result = new int[Math.min(m, n)];
        int index = 0;

        while (a < m && b <n){
            if (nums1[a] == nums2[b]){
                result[index] = nums1[a];
                a++;
                b++;
                index++;
            }
            else if (nums1[a] < nums2[b]){
                a++;
            }else {
                b++;
            }
        }
        return result;
    }

    private void swap(int[] nums, int r, int l) {
        int tmp = nums[r];
        nums[r] = nums[l];
        nums[l] = tmp;
    }


}

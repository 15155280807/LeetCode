package com.example.demo.sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 349. 两个数组的交集
 */
public class Demo06 {


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
     * 输出：[2]
     * 示例 2：
     *
     * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     * 输出：[9,4]
     *  
     *
     * 说明：
     *
     * 输出结果中的每个元素一定是唯一的。
     * 我们可以不考虑输出结果的顺序。
     *
     *
     */
    //方法一  暴力破解
    public int[] intersection(int[] nums1, int[] nums2) {

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int n = nums1.length;
        int m = nums2.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < m; j++) {
                if (nums1[i] == nums2[j]){
                    set.add(nums1[i]);
                }

            }
        }
        int[] ints = new int[set.size()];
        Iterator<Integer> iterator = set.iterator();
        int index =0;
        while (iterator.hasNext()){
            ints[index++]=iterator.next();
        }

        return ints;

    }

    //去重排序
    public int[] intersection2(int[] nums1, int[] nums2) {

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int n = nums1.length;
        int m = nums2.length;
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i = 0; i < n ; i++) {
            set1.add(nums1[i]);
        }
        for (int i = 0; i < m ; i++) {
            set2.add(nums2[i]);
        }
        int[] ints = new int[Math.min(set1.size(), set2.size())];
        int index = 0;
        for (int anInt : set1) {
            for (Integer integer : set2) {
                if (anInt == integer){
                    ints[index] = integer;
                }
            }
        }

        return ints;

    }

}

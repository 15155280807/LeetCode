package com.example.demo.top100;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author jl.yao
 * @className demo02
 * @description 移动零
 * @date 2024/2/26 14:52
 **/
public class demo02 {



    @Test
    public void test(){
        moveZeroes2(new int[]{0,1,0,3,12});
    }

//    输入: nums = [0,1,0,3,12]
//    输出: [1,3,12,0,0]
    public void moveZeroes(int[] nums) {
//        if(nums.length <= 1){
//            return;
//        }
        //构建大于0的区域 和等于0的区域。
        //默认左侧为大于0的区域,初始时无数据，
        int l = -1;
        int index = 0;
        while (index < nums.length) {
            //如果当前值大于0  则将其放在左侧区域
            if (nums[index] > 0  ){
                swap(index,++l,nums);
            }
            index++;

        }

        System.out.println(Arrays.toString(nums));
    }

    public void moveZeroes2(int[] nums) {

        for (int i = 0; i <nums.length-1 ; i++) {
            if (nums[i] == 0){
                nums[i] = nums[i+1];
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    private void swap(int i ,int j ,int[] nums){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}

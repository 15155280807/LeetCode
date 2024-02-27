package com.example.demo.top100;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jl.yao
 * @className demo01
 * @description 两树之和
 * @date 2024/2/26 14:12
 **/
public class demo01 {


    @Test
    public void test(){
        twoSum(new int[]{3,2,4},6);
    }


    public int[] twoSum(int[] nums, int target) {
        //额外空间，借助map
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            //判断目标数是否在map集合中
            if (map.containsKey(target- nums[i])){
                return new int[]{i,map.get(target-nums[i])};
            }
            //先遍历  如果当前值不在map集合就先存入，
            if (!map.containsKey(nums[i])){
                map.put(nums[i],i);
            }
        }

        return null;

    }
}

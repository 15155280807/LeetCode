package com.example.demo.sort;

import com.sun.org.apache.bcel.internal.generic.NEW;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author jl.yao
 * @className Demo09
 * @description 面试题 01.01. 判定字符是否唯一
 * @date 2021/11/17 15:00
 **/
public class Demo09 {

    /**
     * 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
     *
     * 示例 1：
     *
     * 输入: s = "leetcode"
     * 输出: false
     * 示例 2：
     *
     * 输入: s = "abc"
     * 输出: true
     * 限制：
     *
     * 0 <= len(s) <= 100
     * 如果你不使用额外的数据结构，会很加分。

     */
    @Test
    public void test(){
        boolean leetcode = isUnique3("abca");
        System.out.println(leetcode);
    }

    //使用map存储
    public boolean isUnique(String astr) {
        HashMap<Character,Character> map = new HashMap<>();
        for (int i = 0; i < astr.length(); i++) {
            char c = astr.charAt(i);
            Character character = map.get(c);
            if (character != null){
                return false;
            }
            map.put(c,c);
        }
        return true;
    }
    //使用set
    public boolean isUnique2(String astr) {
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < astr.length(); i++) {
            char c = astr.charAt(i);
            set.add(c);
        }
        if (set.size() != astr.length()){
            return false;
        }
        return true;
    }

    //位运算
    public boolean isUnique3(String astr) {
        int mark = 0;
        for (int i = 0; i < astr.length(); i++){
            int move = astr.charAt(i) - 'a';  // 当前字符对应的mark移动的位数
            if ((mark & (1 << move)) != 0){

                return false;
            }
            else{
                mark = mark | (1 << move);
            }

        }
        return true;
    }
}

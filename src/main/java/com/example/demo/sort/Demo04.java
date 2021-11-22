package com.example.demo.sort;

import jdk.nashorn.internal.ir.CallNode;
import org.junit.Test;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * 242. 有效的字母异位词
 */
public class Demo04 {


    @Test
    public void test(){
        boolean flag =isAnagram("anagramt","nagaram");
        System.out.println(flag);

    }


    /**
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     *
     * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
     *
     *  
     *
     * 示例 1:
     *
     * 输入: s = "anagram", t = "nagaram"
     * 输出: true
     * 示例 2:
     *
     * 输入: s = "rat", t = "car"
     * 输出: false
     *  
     *
     * 提示:
     *
     * 1 <= s.length, t.length <= 5 * 104
     * s 和 t 仅包含小写字母
     *
     *
     */
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()){
            return false;
        }
        char[] chars = s.toCharArray();
        char[] chars2 = t.toCharArray();
        Arrays.sort(chars);
        Arrays.sort(chars2);
        return Arrays.equals(chars,chars2);

    }


}

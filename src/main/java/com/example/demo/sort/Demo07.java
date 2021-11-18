package com.example.demo.sort;

import org.junit.Test;
import org.springframework.util.StringUtils;

import java.util.Arrays;

/**
 * @author jl.yao
 * @className Demo07
 * @description 389. 找不同
 * @date 2021/11/17 10:35
 **/
public class Demo07 {


    @Test
    public  void test(){
//        findTheDifference("","y");
        findTheDifference3("","y");
    }


    /**
     * 给定两个字符串 s 和 t，它们只包含小写字母。
     * 字符串t由字符串s随机重排，然后在随机位置添加一个字母。
     * 请找出在 t 中被添加的字母。
     * 示例 1：
     * 输入：s = "abcd", t = "abcde"
     * 输出："e"
     * 解释：'e' 是那个被添加的字母。
     * 示例 2：
     * 输入：s = "", t = "y"
     * 输出："y"
     * 示例 3：
     * 输入：s = "a", t = "aa"
     * 输出："a"
     * 示例 4：
     * 输入：s = "ae", t = "aea"
     * 输出："a"
     * 提示：
     * 0 <= s.length <= 1000
     * t.length == s.length + 1
     * s 和 t 只包含小写字母
     */

    public char findTheDifference(String s, String t) {
        if (s == null || s.equals("")){
            return t.toCharArray()[0];
        }
        char[] chars = s.toCharArray();
        char[] chars1 = t.toCharArray();
        Arrays.sort(chars);
        Arrays.sort(chars1);
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != chars1[i]){
                return chars1[i];
            }
            if (i == chars.length-1  && chars[i] == chars1[i]){
                return chars1[i+1];
            }
        }
        return 0;
    }

    //位运算
    public char findTheDifference2(String s, String t) {
        int ret = 0;
        for (int i = 0; i < s.length(); ++i) {
            ret ^= s.charAt(i);
        }
        for (int i = 0; i < t.length(); ++i) {
            ret ^= t.charAt(i);
        }
        return (char) ret;

    }
    //计数
    public char findTheDifference3(String s, String t) {
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            cnt[ch - 'a']++;
        }
        for (int i = 0; i < t.length(); ++i) {
            char ch = t.charAt(i);
            cnt[ch - 'a']--;
            if (cnt[ch - 'a'] < 0) {
                return ch;
            }
        }
        return ' ';
    }
}

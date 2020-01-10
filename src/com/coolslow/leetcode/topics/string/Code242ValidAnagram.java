package com.coolslow.leetcode.topics.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 有效的字母异位词
 * by MrThanksgiving
 */
public class Code242ValidAnagram {

    /**
     * <pre>
     * 题目：
     *      给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     *
     * 示例 1:
     *      输入: s = "anagram", t = "nagaram"
     *      输出: true
     *
     * 示例 2:
     *      输入: s = "rat", t = "car"
     *      输出: false
     *
     * 说明:
     *      你可以假设字符串只包含小写字母。
     *
     * 进阶:
     *      如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
     *
     * </pre>
     */
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) return false;
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        char[] sIndex = new char[26];
        char[] tIndex = new char[26];
        for (char c : s1) {
            sIndex[c - 'a']++;
        }
        for (char c : t1) {
            tIndex[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (sIndex[i] != tIndex[i]) return false;
        }
        return true;
    }


    public boolean isAnagram2(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) return false;
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s1) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : t1) {
            int i = map.getOrDefault(c, 0);
            if (i == 0) {
                return false;
            } else {
                if (i == 1) map.remove(c);
                else map.put(c, --i);
            }
        }
        return map.size() == 0;
    }

}

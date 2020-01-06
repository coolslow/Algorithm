package com.coolslow.leetcode.topics.string;

/**
 * 实现 strStr()
 * by MrThanksgiving
 */
public class Code28ImplementStrStr {

    /**
     * <pre>
     * 题目：
     *      实现 strStr() 函数。
     *      给定一个 haystack 字符串和一个 needle 字符串，
     *      在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。
     *      如果不存在，则返回  -1。
     *
     * 示例 1:
     *      输入: haystack = "hello", needle = "ll"
     *      输出: 2
     *
     * 示例 2:
     *      输入: haystack = "aaaaa", needle = "bba"
     *      输出: -1
     * 说明:
     *      当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
     *      对于本题而言，当 needle 是空字符串时我们应当返回 0 。
     *      这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
     *
     * </pre>
     */
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) return 0;
        if (haystack == null || haystack.length() == 0 || haystack.length() < needle.length()) return -1;
        int l = 0, r = 0, ln = haystack.length(), rn = needle.length();
        char[] haystackChars = haystack.toCharArray();
        char[] needleChars = needle.toCharArray();
        while (l <= ln - rn) {
            int i = l, j = 0;
            while (haystackChars[i] == needleChars[j]) {
                i++;
                j++;
                if (j == rn) return l;
            }
            l++;
        }
        return -1;
    }

}

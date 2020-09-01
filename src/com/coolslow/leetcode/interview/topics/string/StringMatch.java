package com.coolslow.leetcode.interview.topics.string;

/**
 * Title: StringMatch
 * Desc: 字符串匹配算法详解
 * Date: 2020/9/1 3:56 下午
 * Author: ming
 *
 * REFERENCE: https://blog.csdn.net/v_july_v/article/details/7041827
 */
public class StringMatch {

    /**
     * 暴力解法
     * @param s 文本串 s
     * @param p 模式串 p
     * @return 返回 p 在 s 中的位置的第一个下标或 -1
     *
     * 在暴力算法中：
     * - 如果当前字符串匹配成功（即：s.charAt(i) == p.charAt(j)），则 i++， j++，继续下一个字符的匹配操作
     * - 如果失配（即：s.charAt(i) != p.charAt(j)），即：i = i - j + 1, j = 0。相当于每次匹配失败时，i回溯，j置为0
     */
    public static int bruteForceStringMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();

        int i = 0, j = 0;
        while(i < sLen && j < pLen) {
            // 如果当前字符匹配成功，则i++，j++
            if (s.charAt(i) == p.charAt(j)) {
                i++;
                j++;
            }
            // 如果失配令：i = i - j + 1，j = 0
            else {
                i = i - j + 1;
                j = 0;
            }
        }

        // 匹配成功，j的位置等于模式串p的长度
        // 返回模式串 p 在文本串 s 中的位置，否则返回 -1
        if (j == pLen) {
            return i - j;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        String s = "BBC ABCDAB ABCDABCDABDE";
        String p = "ABCDABD";
        int res = bruteForceStringMatch(s, p);
        System.out.println(res);
    }
}

package com.coolslow.leetcode.interview.topics.string;

/**
 * Title: StringMatch
 * Desc: 字符串匹配算法详解
 * Date: 2020/9/1 3:56 下午
 * Author: ming
 */
public class StringMatch {

    /**
     * 暴力解法
     * @param s 文本串 s
     * @param p 模式串 p
     * @return 返回P在S中的位置的第一个下标或 -1
     */
    public static int bruteForceStringMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();

        int i = 0, j = 0;
        while(i < sLen && j < pLen) {
            if (s.charAt(i) == p.charAt(j)) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }

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

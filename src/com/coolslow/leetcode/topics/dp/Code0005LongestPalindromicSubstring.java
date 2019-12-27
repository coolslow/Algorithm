package com.coolslow.leetcode.topics.dp;

/**
 * 最长回文子串
 * by MrThanksgiving
 */
public class Code0005LongestPalindromicSubstring {

    /**
     * <pre>
     * 题目：
     *      给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
     *      备注：如果一个字符串正着读和反着读是一样的，那它就是回文串。
     *
     * 示例 1：
     *      输入: "babad"
     *      输出: "bab"
     *      注意: "aba" 也是一个有效答案。
     *
     * 示例 2：
     *      输入: "cbbd"
     *      输出: "bb"
     * </pre>
     */
    public String longestPalindrome(String s) {
//        dp[i][j] 为以i开始，j结尾的子串是回文子串
//        dp[i][j] = (s[i] == s[j] && dp[i+1][j-1])

        if (s == null || s.length() == 0) {
            return "";
        }
        if (s.length() == 1) {
            return s;
        }
        char[] chars = s.toCharArray();
        int count = chars.length;
        boolean[][] dp = new boolean[count][count];
        int max = 1;
        int startIndex = 0;
        int endIndex = 0;
        for (int end = 0; end < count; end++) {
            for (int start = 0; start <= end; start++) {
                if (start == end) {
                    dp[start][end] = true;
                } else if (start + 1 == end) {
                    dp[start][end] = chars[start] == chars[end];
                } else if (start + 1 < end) {
                    dp[start][end] = chars[start] == chars[end] && dp[start + 1][end - 1];
                }
                if (dp[start][end] && (end - start + 1) > max) {
                    startIndex = start;
                    endIndex = end;
                    max = endIndex - startIndex + 1;
                }
            }
        }
        return s.substring(startIndex, endIndex + 1);
    }


}

package com.coolslow.leetcode.topics.string;

/**
 * 最长公共前缀
 * by MrThanksgiving
 */
public class Code14LongestCommonPrefix {

    /**
     * <pre>
     * 题目：
     *      编写一个函数来查找字符串数组中的最长公共前缀。
     *      如果不存在公共前缀，返回空字符串 ""。
     *
     * 示例 1:
     *      输入: ["flower","flow","flight"]
     *      输出: "fl"
     *
     * 示例 2:
     *      输入: ["dog","racecar","car"]
     *      输出: ""
     *      解释: 输入不存在公共前缀。
     *
     * 说明:
     *       所有输入只包含小写字母 a-z 。
     *
     * </pre>
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        int count = strs[0].length(), endIndex = 0;
        for (int i = 0; i < count; i++) {
            for (String str : strs) {
                if (i == str.length() || str.charAt(i) != strs[0].charAt(i))
                    return strs[0].substring(0, i);
            }
            endIndex = i + 1;
        }
        return strs[0].substring(0, endIndex);
    }
}

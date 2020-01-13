package com.coolslow.leetcode.top100plus;

/**
 * NO14. 最长公共前缀
 *
 * 编写一个函数来查找字符串数组中最长公共前缀
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例1：
 *      输入: ["flower","flow","flight"]
 *      输出: "fl"
 *
 * 示例 2:
 *
 *      输入: ["dog","racecar","car"]
 *      输出: ""
 *      解释: 输入不存在公共前缀。
 *
 * 说明：
 *      所有输入只包含小写字母 a-z
 */
public class NO14_LongestCommonPrefix {

    /**
     * 方法一：水平扫描法
     * 将第一个数组中的string作为公共str前缀，然后依次遍历数组中的字符串
     * 如果prefix不在str里，就从尾部减去一位作为prefix再验证
     *
     * 因此，时间复杂度是O(S)，S表示所有数组中的字符串的总和。
     *
     * @param strs 给出的字符串
     * @return 返回公共子串
     */
    public static String getTheLongestCommonPrefix(String[] strs) {
        // 数组为空或strs为null时返回""
        if(strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (String str : strs) {
            // indexOf的结果为0表示相同子串的下标从0开始
            while (str.indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }
}

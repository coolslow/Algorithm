package com.coolslow.leetcode.top1000plus;

import java.util.ArrayList;
import java.util.List;

/**
 * 696. 计数二进制子串
 *
 * 给定一个字符串 s，计算具有相同数量0和1的非空(连续)子字符串的数量，并且这些子字符串中的所有0和所有1都是组合在一起的。
 * 重复出现的子串要计算它们出现的次数。
 *
 * 示例 1 :
 * ------------------------------------
 * 输入: "00110011"
 * 输出: 6
 * 解释: 有6个子串具有相同数量的连续1和0：“0011”，“01”，“1100”，“10”，“0011” 和 “01”。
 *
 * 请注意，一些重复出现的子串要计算它们出现的次数。
 * 另外，“00110011”不是有效的子串，因为所有的0（和1）没有组合在一起。
 *
 *
 * 示例 2 :
 * ------------------------------------
 * 输入: "10101"
 * 输出: 4
 * 解释: 有4个子串：“10”，“01”，“10”，“01”，它们具有相同数量的连续1和0。
 *
 *
 * 注意：
 * s.length 在1到50,000之间。
 * s 只包含“0”或“1”字符。
 *
 */
public class NO696_CountBinarySubstrings {

    /**
     * 方法一：按字符分组
     * @param s 给定的0，1的字符串
     * @return 返回有相同0，1字串的数量
     *
     * 时间复杂度和空间复杂度都是 O(n)。
     */
    public int countBinarySubstrings(String s) {
        List<Integer> counts = new ArrayList<>();
        int ptr = 0, n = s.length();
        while (ptr < n) {
            char c = s.charAt(ptr);
            int count = 0;
            while (ptr < n && s.charAt(ptr) == c) {
                ++ptr;
                ++count;
            }
            counts.add(count);
        }
        int ans = 0;
        for (int i = 1; i < counts.size(); ++i) {
            ans += Math.min(counts.get(i), counts.get(i - 1));
        }
        return ans;
    }
}

package com.coolslow.leetcode.top100plus;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 3. 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 "最长子串" 的长度
 *
 * 示例1：
 *      输入："abcabcbb"
 *      输出：3
 *      解释：因为无重复字符串的最长子串是 "abc"，所以其长度为3
 *
 * 示例2：
 *      输入："bbbbb"
 *      输出：1
 *      解释：因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 示例3：
 *      输入: "pwwkew"
 *      输出: 3
 *      解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */

public class NO03_LongestSubstring {

    /**
     * 方法一：暴力解法，时间复杂度为O(n^3)
     * @param s 给定的字符串
     * @return 返回无重复最长子串的长度
     */
    public static int lengthOfLongestSubString(String s) {
        int n = s.length();
        int ans = 0;
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j <= n; j++) {
                if(allUnique(s, i, j)) {
                    ans = Math.max(ans, j - i);
                }
            }
        }
        return ans;
    }

    private static boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for(int i = start; i < end; i++) {
            Character ch = s.charAt(i);
            if(set.contains(ch)) {
                return false;
            }
            set.add(ch);
        }
        return true;
    }

    /**
     * 方法二：滑动窗口
     *
     * 暴力法非常简单，但因为它总是重复的检查字串是否重复，导致它太慢了。
     * 我们都知道，如果从索引i到j - 1之间的子串S(i,j-1)确定没有重复，那么只需检查S(j)对应的字符串是否已尽存在于S(i, j-1)之间即可。
     * 通过使用HashSet作为滑动窗口，可以用O(1)的时间来完成对字符串是否在当前子字符串中的检查。
     *
     *
     */
    public static int lengthOfLongestSubStringWithSlidingWindow(String s) {
        int n = s.length(), ans = 0, i = 0, j = 0;
        Set<Character> set = new HashSet<>();
        while(i < n && j < n) {
            if(!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    /**
     * 思路：
     * - 标签：滑动窗口优化解法
     * 暴力解烦时间复杂度较高，会到达O(n^2)，故采用滑动窗口的方式降低时间复杂度
     * 第一个 map 数据结构存储(k, v)，其中 key 值为字符，value 值为字符位置 + 1，加1表示从字符位置后一个才开始不重复
     * 我们定义不重复子串的开始位置为 start，结束位置为 end
     * 随着 end 不断遍历向后，会遇到与[start, end]区间字符相同的情况，此时将字符作为key值，获取其 value 值，并更新 start，此时[start, end]区间不存在重复字符
     * 无论是否更新 start，都会更新其 map 数据结构和结果 ans。
     * 时间复杂度为：O(n)
     */
    public int lengthOfLongestSubStringWithOptimizedSlidingWindow(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        // 扩展 [i, j] 的滑动窗口
        for(int j = 0, i = 0; j < n; j++) {
            if(map.containsKey(s.charAt(j))) {
                // 设置i的下标
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j -i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
}

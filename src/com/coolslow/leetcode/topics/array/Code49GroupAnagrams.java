package com.coolslow.leetcode.topics.array;

import java.util.*;

/**
 * 字谜分组
 * by MrThanksgiving
 */
public class Code49GroupAnagrams {

    /**
     * <pre>
     * 题目：
     *      给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
     *
     * 示例:
     *      输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
     *      输出:
     *      [
     *        ["ate","eat","tea"],
     *        ["nat","tan"],
     *        ["bat"]
     *      ]
     *
     * 说明：
     *      所有输入均为小写字母。
     *      不考虑答案输出的顺序。
     *
     * </pre>
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return Collections.emptyList();
        Map<Long, List<String>> map = new HashMap<>();
        int[] counter = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
        for (String s : strs) {
            long sum = 1;
            for (int i = 0; i < s.length(); i++) {
                sum *= counter[s.charAt(i) - 'a'];
            }
            if (map.get(sum) != null) {
                map.get(sum).add(s);
            } else {
                map.put(sum, new ArrayList<>());
                map.get(sum).add(s);
            }
        }
        return new ArrayList<>(map.values());
    }
    // 解法1 排序后统计 O(NKLogK)   N字符数组长度，K 每个字符长度。
    // 解法2 字母次数后统计O(NK)
    // 解法3 质数乘积法O(NK).  但是省去了字符串拼接时间。

    public List<List<String>> groupAnagrams2(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        int[] counter = new int[26];
        for (String s : strs) {
            Arrays.fill(counter, 0);
            for (int i = 0; i < s.length(); i++) {
                counter[s.charAt(i) - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                sb.append(counter[i]);
                sb.append("-");
            }
            map.computeIfAbsent(sb.toString(), k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(map.values());
    }


}

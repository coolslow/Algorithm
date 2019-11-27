package com.coolslow.leetcode.top100.playground;

import com.coolslow.common.Playground;

import java.util.HashSet;
import java.util.Set;

@Playground(name = "最长子串", rank = Playground.Difficulty.Medium)
public class LongestSubstringPlayground {

    /**
     * 暴力解法
     * @param s 输入的字符串
     * @return 返回最长子串的长度值
     */
    public static int lengthOfLongestSubString(String s) {
        int ans = 0;
        for(int i = 0; i < s.length(); i++) {
            for(int j = i + 1; j <= s.length(); j++) {
                if(allUnique(s, i, j)) {
                    ans = Math.max(ans, j - i);
                }
            }
        }
        return ans;
    }

    // 判断HashSet中的字符是否唯一
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
}

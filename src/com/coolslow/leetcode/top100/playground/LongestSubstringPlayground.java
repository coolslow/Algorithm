package com.coolslow.leetcode.top100.playground;

import com.coolslow.common.Playground;
import com.coolslow.common.Solution;
import com.coolslow.common.Topics;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Playground(name = "最长子串", rank = Playground.Difficulty.Medium)
public class LongestSubstringPlayground {

    /**
     * 暴力解法
     * @param s 输入的字符串
     * @return 返回最长子串的长度值
     */
    @Solution(desc = "解法1：查找最长子串 - 暴力解法")
    @Topics(tags = Topics.Tags.String)
    public static int lengthOfLongestSubString(String s) {
        int ans = 0;
        for(int i = 0; i < s.length(); i++) {
            for(int j = i + 1; j <= s.length(); j++) {
                if(allUnique(s, i, j)) {
                    // 比较 ans 和 (j - i)的大小，(j - i)表示子串的长度
                    ans = Math.max(ans, j - i);
                }
            }
        }
        return ans;
    }
    /**
     * 暴力方法的子方法，判断HashSet中的字符是否唯一，如果包含，则直接返回false，否则添加到Set中
     * @param s 传入的字符串
     * @param start 开始比较的起点下标
     * @param end 开始比较的终点下表
     * @return 返回字符串是否唯一的标记
     */
    private static boolean allUnique(String s, int start, int end) {
        // 每次比较的时候都需要新创建一个HashSet对象的实例
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
     * 用HashSet来作为滑动窗口，检查一个字符串是否在HashSet中的时间复杂度为O(1)
     * 这个问题中，我们用HashSet来存储滑动窗口中的字符串。这个滑动窗口的初始大小为 window[i, j)（左闭右开，初始状态 j = i）
     * 接着将右侧区间 j 向右滑动。当将 j 作为下标的元素如果不在HashSet中，就将右侧区间继续向右滑动更远的距离。持续滑动直到 j 为下标的元素存在于HashSet中。
     * 至此，我们找到了以i开头的最长子串。如果对于所有的i执行上述操作，我们就能获得最终的答案。
     *
     * @param s
     * @return
     */
    @Solution(desc = "解法2：查找最长子串 - 滑动窗口")
    @Topics(tags = Topics.Tags.String)
    public static int lengthOfLongestSubstringWithSlidingWindow(String s) {
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < s.length() && j < s.length()) {
            if(!set.contains(s.charAt(j))) {
                // 将滑动窗口的区间向右移动
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                // 将滑动窗口左区间向右移动
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    /**
     * 滑动窗口优化解法:
     * 采用滑动窗口的解决办法至少需要2n步。实际上，是可以被优化为仅有n步。
     * 通过采用mapping字符串的下标的方式，可以取代用HashSet来判断字符串是否存在。这样，我们就可以在发现重复的字符是立刻跳过该字符。
     * 原因是：如果 s[j] 在[i, j)范围里与下标j'是重复的，就没有必要一点点的增加i。可以直接忽略所有在[i, j)范围里的所有元素，让j直接变为 j'+1。
     *
     * @param s
     * @return
     */
    @Solution(desc = "解法3：查找最长子串 - 滑动窗口优化解决办法")
    @Topics(tags = Topics.Tags.String)
    public static int lengthOfLongestSubstringWithOptimizedSlidingWindow(String s) {
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int j = 0, i = 0; j < s.length(); j++) {
            if(map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
}

package com.coolslow.leetcode.topics.string;

import java.util.HashMap;
import java.util.Map;

/**
 * by MrThanksgiving
 */
public class Code387FirstUniqueCharacterInAString {

    /**
     * <pre>
     * 题目：
     *      给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
     *
     * 案例:
     *      s = "leetcode"
     *      返回 0.
     *
     *      s = "loveleetcode",
     *      返回 2.
     *
     * 注意事项：您可以假定该字符串只包含小写字母。
     *
     * </pre>
     */
    public int firstUniChar(String s) {
        if (s == null || s.length() == 0) return -1;
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : chars) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < chars.length; i++) {
            if (map.get(chars[i]) == 1) return i;
        }
        return -1;
    }

}

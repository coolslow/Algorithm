package com.coolslow.leetcode.top1000plus;

import java.util.HashMap;
import java.util.Map;

/**
 * 387. 字符串中的第一个唯一字符
 *
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回-1
 *
 * 案例:
 * s = "leetcode"
 * 返回 0.
 * s = "loveleetcode",
 * 返回 2.
 *
 * 注意事项：可以假定该字符串只包含小写字母。
 */
public class NO387_FirstUniqueCharInString {

    /**
     * 通过HashMap处理
     * @param str 给定的字符串
     * @return 返回第一个唯一字符
     */
    public static int firstQuiqueCharInString(String str) {

        int len = str.length();
        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < len; i++) {
            char c = str.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for(int i = 0; i < len; i++) {
            if(map.get(str.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }
}

package com.coolslow.leetcode.top1000plus;

import java.util.Arrays;

/**
 * 292. 有效的字母异位词
 *
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 *
 * 示例 2:
 * 输入: s = "rat", t = "car"
 * 输出: false
 *
 * [说明]:
 * 你可以假设字符串只包含小写字母。
 *
 * [进阶]:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 */
public class NO292_ValidAnagram {

    /**
     * 算法一：排序
     * 通过将 s 的字母重新排列成 t 来生成变位词。因此，如果 T 是 S 的变位词，对两个字符串进行排序将产生两个相同的字符串。
     * 此外，如果 s 和 t 的长度不同，t 不能是 s 的变位词，我们可以提前返回。
     *
     * 时间复杂度：O(nlogn)，空间复杂度：O(1)
     *
     * @param s 字符串s
     * @param t 字符串t
     * @return 返回是否变位词的判断，true表示是变位词，false表示不是
     */
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);

        return Arrays.equals(str1, str2);
    }
}

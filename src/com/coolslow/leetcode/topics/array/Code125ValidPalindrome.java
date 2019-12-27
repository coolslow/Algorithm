package com.coolslow.leetcode.topics.array;

/**
 * 验证回文串
 * by MrThanksgiving
 */
public class Code125ValidPalindrome {

    /**
     * <pre>
     * 题目：
     *      给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
     *
     * 说明：
     *      本题中，我们将空字符串定义为有效的回文串。
     *
     * 示例 1:
     *      输入: "A man, a plan, a canal: Panama"
     *      输出: true
     *
     * 示例 2:
     *      输入: "race a car"
     *      输出: false
     * </pre>
     */
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0 || s.length() == 1) {
            return true;
        }
        int l = 0;
        int r = s.length() - 1;
        while (l <= r) {
            if (!Character.isLetterOrDigit(s.charAt(l))) {
                l++;
                continue;
            }
            if (!Character.isLetterOrDigit(s.charAt(r))) {
                r--;
                continue;
            }
            if (Character.toLowerCase(s.charAt(l++)) != Character.toLowerCase(s.charAt(r--)))
                return false;
        }
        return true;
    }

}

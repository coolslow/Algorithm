package com.coolslow.leetcode.topics.array;

/**
 * 反转字符串中的元音字母
 * by MrThanksgiving
 */
public class Code345ReverseVowelsOfAString {

    /**
     * <pre>
     * 题目：
     *      编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
     *
     * 示例 1:
     *      输入: "hello"
     *      输出: "holle"
     *
     * 示例 2:
     *      输入: "leetcode"
     *      输出: "leotcede"
     *
     * 说明:
     *      元音字母不包含字母"y"。
     *
     * </pre>
     */
    public String reverseVowels(String s) {
        // a, e, i, o, u
        if (s == null || s.length() == 0 || s.length() == 1) {
            return s;
        }
        int l = 0;
        int r = s.length() - 1;
        char[] chars = s.toCharArray();
        while (l < r) {
            while (l < r) {
                char ch = Character.toLowerCase(chars[l]);
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
                    break;
                l++;
            }
            while (l < r) {
                char ch = Character.toLowerCase(chars[r]);
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
                    break;
                r--;
            }
            if (l < r) {
                char t = chars[l];
                chars[l++] = chars[r];
                chars[r--] = t;
            }
        }
        return new String(chars);
    }

}

package com.coolslow.leetcode.top100plus;

/**
 * 125. 验证回文
 *
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 *
 * 示例 2:
 * 输入: "race a car"
 * 输出: false
 */
public class NO125_ValidPalindrome {
    /**
     * 逐个字符读取到StringBuffer，过滤不需要字符，并进行大小写转换。
     * 最后使用StringBuffer的reverse()方法翻转字符串，判断是否相等即可。
     *
     * @param s 输入的字符串
     * @return boolean值，回文返回true，非回文返回false
     */
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (((c >= 'a') && (c <= 'z')) || ((c >= '0') && (c <= '9'))) {
                sb.append(c);
            }
            if ((c >= 'A') && (c <= 'Z')) {
                sb.append((char)(c + 32));
            }
        };
        return sb.toString().equals(sb.reverse().toString());
    }
}

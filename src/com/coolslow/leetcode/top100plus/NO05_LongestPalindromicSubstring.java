package com.coolslow.leetcode.top100plus;

/**
 * 5. 最长回文子串
 *
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例1：
 *      输入: "babad"
 *      输出: "bab"
 *      注意: "aba" 也是一个有效答案。
 *
 * 示例2：
 *      输入: "cbbd"
 *      输出: "bb"
 *
 * 解法：暴力破解法
 *
 * 解法：动态规划
 *      由于暴力解法的时间复杂度为O(n^3)，为避免在验证回文时进行不必要的重复计算。
 *      那么：如果已经确认是一个回文子串，那么它左由两侧是相同字母的话，必定是回文的。
 *
 *      时间复杂度：O(n^2)
 *      空间复杂度：O(n^2)
 *
 * 解法：中心扩展法
 *      我们观察到回文中心的两侧互为镜像。因此，回文可以从它的中心展开，并且只有 2n - 1 个这样的中心。
 *
 * 解法：Manacher 算法
 *      还有一个复杂度为 O(n)的 Manacher 算法。然而，这是一个非同寻常的算法，在 45 分钟的编码时间内提出这个算法将会是一个不折不扣的挑战。
 *      理解它，将是非常有趣的。
 *
 */
public class NO05_LongestPalindromicSubstring {

    /**
     * 暴力破解法
     * @return 返回回文子串
     */
    public static String longestPalindromicSubString(String s) {
        String ans = "";
        int max = 0;
        int len = s.length();

        for(int i = 0; i < len; i++) {
            for(int j = i + 1; j <= len; j++) {
                String test = s.substring(i, j);
                if(isPalindromic(test) && test.length() > max) {
                    ans = s.substring(i, j);
                    max = Math.max(max, ans.length());
                }
            }
        }
        return ans;
    }

    /**
     * 判断是否为回文
     * @param s 子字符串
     * @return 返回是否回文的标记
     */
    private static boolean isPalindromic(String s) {
        int len = s.length();
        for(int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }
}

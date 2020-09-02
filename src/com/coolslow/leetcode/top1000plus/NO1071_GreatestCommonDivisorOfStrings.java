package com.coolslow.leetcode.top1000plus;

/**
 * 1071. 字符串的最大公因子
 *
 * 对于字符串s和t，只有在 s = t + ... + t (t与自身连接一次或多次)时，才认定"t 能除尽 s"
 * 返回最长字符串 x，要求满足x能除尽 str1 且 x 也能除尽 str2。
 *
 * 示例 1：
 * 输入：str1 = "ABCABC", str2 = "ABC"
 * 输出："ABC"
 *
 * 示例 2：
 * 输入：str1 = "ABABAB", str2 = "ABAB"
 * 输出："AB"
 *
 * 示例 3：
 * 输入：str1 = "LEET", str2 = "CODE"
 * 输出：""
 *
 */
public class NO1071_GreatestCommonDivisorOfStrings {
    /**
     * 使用辗转相除法解决
     * reference: https://zhuanlan.zhihu.com/p/31824895
     *
     * @param str1 第一个字符串
     * @param str2 第二个字符串
     * @return 返回最大公约字符串
     */
    public static String gcdOfString(String str1, String str2) {
        // 假设str1是N个x，str2是M个x，那么str1+str2肯定是等于str2+str1的。
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        // 辗转相除法求gcd。
        return str1.substring(0, gcd(str1.length(), str2.length()));
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a: gcd(b, a % b);
    }
}

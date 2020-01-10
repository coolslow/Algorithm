package com.coolslow.leetcode.topics.math;

/**
 * 字符串转换整数
 * by MrThanksgiving
 */
public class Code8StringToInteger {

    /**
     * <pre>
     * 题目：
     *      请你来实现一个 atoi 函数，使其能将字符串转换成整数。
     *      首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
     *      当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；
     *      假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
     *      该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
     *
     * 注意：
     *      假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
     *      在任何情况下，若函数不能进行有效的转换时，请返回 0。
     *
     * 说明：
     *      假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−2^31,  2^31 − 1]。
     *      如果数值超过这个范围，请返回  INT_MAX (2^31 − 1) 或 INT_MIN (−2^31) 。
     *
     * 示例 1:
     *      输入: "42"
     *      输出: 42
     *
     * 示例 2:
     *      输入: "   -42"
     *      输出: -42
     *      解释: 第一个非空白字符为 '-', 它是一个负号。
     *           我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
     *
     * 示例 3:
     *      输入: "4193 with words"
     *      输出: 4193
     *      解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
     *
     * 示例 4:
     *      输入: "words and 987"
     *      输出: 0
     *      解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
     *           因此无法执行有效的转换。
     *
     * 示例 5:
     *      输入: "-91283472332"
     *      输出: -2147483648
     *      解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
     *           因此返回 INT_MIN (−231) 。
     *
     * </pre>
     */
    public int myAToI(String str) {
        if (str == null || str.length() == 0) return 0;
        char[] chars = str.toCharArray();
        int count = chars.length;
        boolean positive = true;
        int result = 0;
        int l = 0;
        while (l < count && chars[l] == ' ')
            l++;
        if (l < count && (chars[l] == '+' || chars[l] == '-')) {
            positive = chars[l] != '-';
            l++;
        }
        for (int i = l; i < count; i++) {
            char c = chars[i];
            if (Character.isDigit(c)) {
                if (positive) {
                    if ((Integer.MAX_VALUE - (c - 48)) / 10 < result)
                        return Integer.MAX_VALUE;
                } else {
                    if ((Integer.MIN_VALUE + (c - 48)) / 10 > -result)
                        return Integer.MIN_VALUE;
                }
                result = result * 10 + (c - 48);
            } else {
                break;
            }
        }
        return positive ? result : -result;
    }

    public int myAToI2(String str) {
        if (str == null || str.length() == 0) return 0;
        char[] chars = str.toCharArray();
        int l = 0, sign = 1, count = chars.length;
        long result = 0;
        while (l < count && chars[l] == ' ') l++;
        if (l < count && chars[l] == '+') {
            l++;
        } else if (l < count && chars[l] == '-') {
            l++;
            sign = -1;
        }
        while (l < count && chars[l] >= '0' && chars[l] <= '9') {
            result = result * 10 + chars[l++] - '0';
            if (result != (int) result)
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        return (int) (sign * result);
    }


}

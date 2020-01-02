package com.coolslow.leetcode.top100;

/**
 * 8. 字符串转换整数（atoi）
 *
 * 实现一个atoi函数，使其能将字符串转换成整数。
 *
 * 首先，该函数会根据需要丢弃无用的开通空格字符，直到找到第一个非空的字符为止。
 * 当寻找到的第一个非空字符为正或者负号时，则将该符号与只后面尽可能多的连续数字组合起来，作为该整数的正负号。
 * 假如第一个非空字符串是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 *
 * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，他们对于函数不应该造成影响。
 *
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数数字，字符串为空或者字符串仅包含空白字符时，则你的函数不需要进行转换。
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0。
 *
 * 说明：
 * 假设环境只能存储32位大小的有符号整数，那么其数值范围为[-2^31, 2^31 - 1]。
 * 如果数值超过这个范围，请返回：INT_MAX(2^31 - 1)或INT_MIN(-2^31)
 *
 * 示例1：
 *      输入："42"
 *      输出：42
 *
 * 示例2：
 *      输入："    -42"
 *      输出：-42
 *
 * 示例3：
 *      输入："4193 with words"
 *      输出：4193
 *      解释：转换截止于数字 '3'，因为他的下一个字符不为数字。
 *
 * 示例4：
 *      输入："words and 987"
 *      输出：0
 *      解释：第一个非空字符串是'w'，但它不是数字或正、负号。因此无法执行有效的转换。
 *
 * 示例5：
 *      输入: "-91283472332"
 *      输出: -2147483648
 *      解释: 数字 "-91283472332" 超过 32 位有符号整数范围。 因此返回 INT_MIN (−231) 。
 *
 *
 */
public class NO08_StringToInteger {
    public static int myAtoi(String str) {
        if(str == null || str.length() ==0) {
            return 0;
        }
        int i = 0;
        while(i < str.length() && str.charAt(i) == ' ') {
            i++;
        }

        if(i == str.length()) {
            return 0;
        }
        int sign = 1;
        if(str.charAt(i) == '+' || str.charAt(i) == '-') {
            if(str.charAt(i) == '-') {
                sign = -1;
            }
            i++;
        }
        if(i >= str.length() || !isDigit(str.charAt(i))) {
            return 0;
        }
        long val = 0L;
        while(i < str.length() && isDigit(str.charAt(i))) {
            val = val * 10 + str.charAt(i) - '0';
            long temp = sign * val;
            if(temp < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            if(temp > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            i++;
        }
        return (int)(val * sign);
    }

    private static boolean isDigit(char ch) {
        return (ch >= '0' && ch <= '9');
    }
}

package com.coolslow.leetcode.topics.math;

/**
 * 整数反转
 * by MrThanksgiving
 */
public class Code7ReverseInteger {

    /**
     * <pre>
     * 题目：
     *      给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
     *
     * 示例 1:
     *      输入: 123
     *      输出: 321
     *
     *  示例 2:
     *      输入: -123
     *      输出: -321
     *
     * 示例 3:
     *      输入: 120
     *      输出: 21
     *
     * 注意:
     * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。
     * 请根据这个假设，如果反转后整数溢出那么就返回 0。
     * </pre>
     */
    public int reverse(int x) {
        long y = 0;
        while (x != 0) {
            y = y * 10 + (x % 10);
            x /= 10;
        }
        if ((int) y != y)
            return 0;
        else
            return (int) y;
    }

}

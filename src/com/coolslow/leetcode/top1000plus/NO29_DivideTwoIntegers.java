package com.coolslow.leetcode.top1000plus;

/**
 * 29. 两数相除
 *
 * 题目：给定两个整数，被除数 dividend 和 除数 divisor。将两数相除，要求不使用乘法、除法和mod运算符。
 * 返回被除数 dividend 除以 divisor 得到的商。
 *
 * 整数除法的结果应当截去(truncate)其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 *
 * 示例 1:
 *  输入: dividend = 10, divisor = 3
 *  输出: 3
 *  解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
 *
 * 示例 2:
 *  输入: dividend = 7, divisor = -3
 *  输出: -2
 *  解释: 7/-3 = truncate(-2.33333..) = -2
 *
 *
 * 提示：
 *   - 被除数和除数均为 32 位有符号整数。
 *   - 除数不为 0。
 *   - 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2^31,  2^31 − 1]。本题中，如果除法结果溢出，则返回 2^31 − 1。
 */
public class NO29_DivideTwoIntegers {

    /**
     * 算法思路：泰勒展开式
     * 这个相当于是2的幂次的展开，任何一个数K可以被表示为：K = b0 * 2^0 + b1 * 2^1 + b2 * 2^2 + ... + bn * 2^n + ...
     *
     * @param dividend 被除数
     * @param divisor 除数
     * @return 返回被除数 dividend 除以 divisor 得到的商
     */
    public static int divide(int dividend, int divisor) {
        // 根据除数和被除数是否大于0来设置返回结果的标记
        boolean sign = (dividend > 0) ^ (divisor > 0);
        // 设置返回的商的默认值为0
        int result = 0;

        // 将被除数转为负数
        if(dividend > 0) {
            dividend = -dividend;
        }
        // 将除数转为负数
        if(divisor > 0) {
            divisor = -divisor;
        }

        // 在被除数小于除数的情况下（一个负数小于另外一个负数，则 dividend 的绝对值比 divisor 的绝对值大
        while(dividend <= divisor) {
            int tempResult = -1;
            int tempDivisor = divisor;

            while(dividend <= (tempDivisor << 1)) {
                if(tempDivisor <= (Integer.MIN_VALUE >> 1)){
                    break;
                }
                tempResult = tempResult << 1;
                tempDivisor = tempDivisor << 1;
            }
            dividend = dividend - tempDivisor;
            result += tempResult;
        }
        if(!sign) {
            if(result <= Integer.MIN_VALUE) {
                return Integer.MAX_VALUE;
            }
            result = - result;
        }
        return result;
    }
}

package com.coolslow.leetcode.top1000plus;

/**
 * 50. 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 *
 * 示例 1:
 *      输入: 2.00000, 10
 *      输出: 1024.00000
 *
 * 示例 2:
 *      输入: 2.10000, 3
 *      输出: 9.26100
 *
 * 示例 3:
 *
 *      输入: 2.00000, -2
 *      输出: 0.25000
 *      解释: 2^(-2) = 1/(2^2) = 1/4 = 0.25
 *
 * 说明:
 *
 *      -100.0 < x < 100.0
 *      n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 *
 */
public class NO50_Powx_N {

    /**
     * 解法一：暴力解决办法
     *
     * 思路：
     *      直观的解决办法，将 x 连乘 n 次
     *      如果 n 是小于 0 的负整数，可以用 1/x，-n 代替x，n 来保证 n >= 0。
     *
     *      仍然需要关注边界条件。
     *
     * 复杂度分析：
     *      时间复杂度：O(n). 我们需要将 x 连乘 n 次。
     *      空间复杂度：O(1). 我们只需要一个变量来保存最终 x 的连乘结果。
     *
     * @param x 给定的双精度数
     * @param n 给定的 n 次方
     * @return 返回正确的结果（双精度数）
     */
    public static double myPow(double x, int n) {
        int num = n;
        if(num < 0) {
            x = 1 / x;
            num = -num;
        }

        // 注意，这里需要为 ans 赋值为 1
        double ans = 1;
        for(long i = 0; i < num; i++) {
            ans = ans * x;
        }

        return ans;
    }

    /**
     * 解法二：快速幂算法（递归）
     *
     * 直观想法：
     *      假设已经得到 x^n 的结果，如何得到 x^2n 的结果。很明显，不需要将 x 再乘n次。使用公式：(x^n)^2 = x^2n。
     *      我们可以在一次计算内得到 x^2n 的值。使用该优化方法，可以进一步降低算法的时间复杂度。
     *
     * 算法：
     *      假定我们已经得到了 x^(n/2) 的结果，并且我们现在想得到 x^n 的结果。
     *      需要令 A =  x^(n/2)，然后根据 n 的奇偶性来分别讨论 x^n 的值。
     *      - 如果 n 为偶数，可以用公式(x^n)^2 = x^(2 * n) 得到。
     *      - 如果 n 为奇数，那么 A * A = x^(n-1)。直观的，可以再乘一次x，即：x^n = A * A * x 得到。
     *
     *      利用上面的办法，可以在最多O(logn)的时间复杂度内就得结果
     *
     *
     * 复杂度分析：
     *      时间复杂度：O(logn)
     *      空间复杂度：O(logn)。每一次计算，我们需要存储 x^(n/2)的结果，需要计算O(logn)次，所以空间复杂度为O(logn)。
     *
     * @param x 给定的双精度数
     * @param n 给定的 n 次方
     * @return 返回正确的结果（双精度数）
     */
    public static double powWithBetterMethod(double x, int n) {
        long num = n;
        if (num < 0) {
            x = 1 / x;
            num = -num;
        }

        return fastPow(x, num);
    }

    /**
     * 递归实现pow计算
     */
    private static double fastPow(double x, long n) {
        // 讨论 n 为 0 的情况
        if( n == 0) {
            return 1.0;
        }

        // 考虑 x^(n/2)的情况
        double half = fastPow(x, n / 2);
        // 当 n 为偶数时
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }

    /**
     * 解法三：快速幂算法（循环）
     *
     * 思路：使用公式：X^(a + b) = X^a * X^b。因此，我们可以将 n 看作一系列正整数之和。
     *
     * 时间复杂度O(logn)，对每一个 n 的二进制位表示，我们都至多需要累乘 1 次，所以总的时间复杂度为 O(logn)
     * 空间复杂度O(1)。我们只需要用到2个变量保存当前的乘积和最终结果。
     */
    public static double myFastPow(double x, int n) {
        long num = n;
        if(num < 0) {
            x = 1/x;
            num = -num;
        }

        double ans = 1;
        double currentProduct = x;

        for(long i = num; i > 0;i /= 2) {
            if((i%2) == 1) {
                ans = ans * currentProduct;
            }
            currentProduct = currentProduct * currentProduct;
        }

        return ans;
    }
}

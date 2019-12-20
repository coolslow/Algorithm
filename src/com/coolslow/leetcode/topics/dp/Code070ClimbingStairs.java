package com.coolslow.leetcode.topics.dp;

import com.coolslow.datastruct.utils.MyUtils;
import org.junit.Test;

/**
 * 爬楼梯
 * by MrThanksgiving
 */
public class Code070ClimbingStairs {

    /**
     * <pre>
     * 题目：
     *      假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     *      每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     *      注意：给定 n 是一个正整数。
     *
     * 示例 1：
     *      输入： 2
     *      输出： 2
     *      解释： 有两种方法可以爬到楼顶。
     *      1.  1 阶 + 1 阶
     *      2.  2 阶
     *
     * 示例 2：
     *      输入： 3
     *      输出： 3
     *      解释： 有三种方法可以爬到楼顶。
     *      1.  1 阶 + 1 阶 + 1 阶
     *      2.  1 阶 + 2 阶
     *      3.  2 阶 + 1 阶
     * </pre>
     */
    public int climbStairs(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
    /*
     * 执行用时 : 1 ms, 在所有 java 提交中击败了17.11%的用户
     * 内存消耗 :32.7 MB, 在所有 java 提交中击败了75.63%的用户
     */

    @Test
    public void testClimbStairs() {
        int result = climbStairs(3);
        MyUtils.print(MyUtils.ANSI_RED + result + MyUtils.ANSI_RESET);
    }


}

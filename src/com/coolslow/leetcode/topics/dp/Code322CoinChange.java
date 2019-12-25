package com.coolslow.leetcode.topics.dp;

import com.coolslow.datastruct.utils.MyUtils;
import org.junit.Test;

import java.util.Arrays;

/**
 * 零钱兑换
 * by MrThanksgiving
 */
public class Code322CoinChange {

    /**
     * <pre>
     * 题目：
     *      给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
     *      如果没有任何一种硬币组合能组成总金额，返回 -1。
     *
     * 示例 1:
     *      输入: coins = [1, 2, 5], amount = 11
     *      输出: 3
     *      解释: 11 = 5 + 5 + 1
     *
     * 示例 2:
     *      输入: coins = [2], amount = 3
     *      输出: -1
     *
     * 说明:
     *      你可以认为每种硬币的数量是无限的。
     *
     * 备注：
     *      而且面值数组中的数没有大小顺序，所以应该考虑动态规划，而不是贪心算法
     *
     * </pre>
     */
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount <= 0) {
            return 0;
        }
        // dp[i] i表示余额, dp[i]用到的最少硬币数。
        // 把它想像成爬楼梯问题。爬到amount最少步数。（爬到amount共有多少种方法，最少步数就是其中一个)

        int count = coins.length;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    @Test
    public void testSolution() {
        int[] coins = {1, 2, 5};//11
//        int[] coins = {2};//3
//        int[] coins = {2, 5, 10, 1}; //27
        int result = coinChange(coins, 11);
        MyUtils.print(MyUtils.ANSI_RED + result + MyUtils.ANSI_RESET);
    }

}

package com.coolslow.leetcode.topics.dp;

/**
 * 买卖股票的最佳时机IV
 * by MrThanksgiving
 */
public class Code123BestTimeToBuyAndSellStockIV {

    /**
     * <pre>
     * 题目：
     *      给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
     *      设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
     *      注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     *
     * 示例 1:
     *      输入: [2,4,1], k = 2
     *      输出: 2
     *      解释: 在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
     *
     * 示例 2:
     *      输入: [3,2,6,5,0,3], k = 2
     *      输出: 7
     *      解释: 在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
     *           随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。
     *
     * </pre>
     */
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0 || prices.length == 1 || k <= 0) {
            return 0;
        }
        int count = prices.length;
        if (k > count / 2) {
            return maxProfitInf(prices);
        }
        int maxTransaction = k + 1;

        int[][][] dp = new int[count][2][maxTransaction];
        for (int i = 0; i < maxTransaction; i++) {
            dp[0][0][i] = 0;
            dp[0][1][i] = -prices[0];
        }
        for (int i = 1; i < count; i++) {
            for (int j = 1; j < maxTransaction; j++) {
                dp[i][0][j] = Math.max(dp[i - 1][0][j], dp[i - 1][1][j] + prices[i]);
                dp[i][1][j] = Math.max(dp[i - 1][1][j], dp[i - 1][0][j - 1] - prices[i]);
            }
        }
        return dp[count - 1][0][maxTransaction - 1];
    }

    public int maxProfitInf(int[] prices) {
        if (prices == null || prices.length == 0 || prices.length == 1) {
            return 0;
        }
        int count = prices.length;
        int[][] dp = new int[count][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        int max = 0;
        for (int i = 1; i < count; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[count - 1][0];
    }


}

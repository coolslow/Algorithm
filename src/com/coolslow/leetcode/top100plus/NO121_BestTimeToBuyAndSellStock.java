package com.coolslow.leetcode.top100plus;

/**
 * 121. 买卖股票的最佳时机
 *
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 如果你最多只允许完成一笔交易（即：买入和卖出一支股票），设计一个算法来计算你能获取的最大利润。
 *
 * 注意：你不能在买入股票前卖出股票
 *
 * 示例1：
 *      输入：[7, 1, 5, 3, 6, 4]
 *      输出：5
 *      解释：在第 2 天（股票价格 = 1）的时候买入，在第五天（股票价格 = 6）的时候卖出，最大利润：6 - 1 = 5
 *
 * 示例2：
 *      输入：[7, 6, 4, 3, 1]
 *      输出：0
 *      解释：在这种情况下，没有完成交易，所以最大利润为 0
 *
 *
 * @思路
 *      需要在给定的数组中找出两个数的最大差值（即：最大收益），并且，第二个数（卖出价格）必须比第一个数（买入价格）大。
 *      即，为每一个满足条件的i, j（j > i）找到：Max(prices[j] - prices[i])
 */
public class NO121_BestTimeToBuyAndSellStock {

    /** 暴力解法，时间复杂度为O(n^2) */
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        for(int i = 0; i < prices.length; i++) {
            for(int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if(profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }
        return maxProfit;
    }

    /**
     * 一次遍历
     *
     */
    public static int maxProfitWithOnePass(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int i = 0; i < prices.length; i++) {
            if(prices[i] < minPrice) {
                minPrice = prices[i];
            } else if(prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }
}

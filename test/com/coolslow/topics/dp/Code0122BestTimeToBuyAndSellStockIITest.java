package com.coolslow.topics.dp;

import com.coolslow.datastruct.utils.MyUtils;
import com.coolslow.leetcode.topics.dp.Code122BestTimeToBuyAndSellStockII;
import org.junit.Test;

/**
 * 买卖股票的最佳时机II
 * by MrThanksgiving
 */
public class Code122BestTimeToBuyAndSellStockIITest {


    @Test
    public void testSolution() {
        Code122BestTimeToBuyAndSellStockII solution = new Code122BestTimeToBuyAndSellStockII();
        int[] prices = {7, 1, 5, 3, 6, 4};
//        int[] prices = {7, 6, 4, 3, 1};
//        int[] prices = {1, 2, 3, 4, 5};
        int result = solution.maxProfit2(prices);
        MyUtils.print(MyUtils.ANSI_RED + result + MyUtils.ANSI_RESET);
    }

}

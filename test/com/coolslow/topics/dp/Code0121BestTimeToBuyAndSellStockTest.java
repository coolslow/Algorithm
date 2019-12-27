package com.coolslow.topics.dp;

import com.coolslow.datastruct.utils.MyUtils;
import com.coolslow.leetcode.topics.dp.Code0121BestTimeToBuyAndSellStock;
import org.junit.Test;

/**
 * 买卖股票的最佳时机
 * by MrThanksgiving
 */
public class Code0121BestTimeToBuyAndSellStockTest {


    @Test
    public void testSolution() {
        Code0121BestTimeToBuyAndSellStock solution = new Code0121BestTimeToBuyAndSellStock();
//        int[] prices = {7, 1, 5, 3, 6, 4};
        int[] prices = {7, 6, 4, 3, 1};
        int result = solution.maxProfit(prices);
        MyUtils.print(MyUtils.ANSI_RED + result + MyUtils.ANSI_RESET);
    }

}

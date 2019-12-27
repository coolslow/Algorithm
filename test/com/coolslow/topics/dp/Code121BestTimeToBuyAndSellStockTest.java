package com.coolslow.topics.dp;

import com.coolslow.datastruct.utils.MyUtils;
import com.coolslow.leetcode.topics.dp.Code121BestTimeToBuyAndSellStock;
import org.junit.Test;

/**
 * 买卖股票的最佳时机
 * by MrThanksgiving
 */
public class Code121BestTimeToBuyAndSellStockTest {


    @Test
    public void testSolution() {
        Code121BestTimeToBuyAndSellStock solution = new Code121BestTimeToBuyAndSellStock();
//        int[] prices = {7, 1, 5, 3, 6, 4};
        int[] prices = {7, 6, 4, 3, 1};
        int result = solution.maxProfit(prices);
        MyUtils.print(MyUtils.ANSI_RED + result + MyUtils.ANSI_RESET);
    }

}

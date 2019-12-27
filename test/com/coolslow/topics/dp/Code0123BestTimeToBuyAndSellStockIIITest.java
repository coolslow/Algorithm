package com.coolslow.topics.dp;

import com.coolslow.datastruct.utils.MyUtils;
import com.coolslow.leetcode.topics.dp.Code0123BestTimeToBuyAndSellStockIII;
import org.junit.Test;

/**
 * 买卖股票的最佳时机III
 * by MrThanksgiving
 */
public class Code0123BestTimeToBuyAndSellStockIIITest {

    @Test
    public void testSolution() {
        Code0123BestTimeToBuyAndSellStockIII solution = new Code0123BestTimeToBuyAndSellStockIII();

        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};//6
//        int[] prices = {1, 2, 3, 4, 5};//4
//        int[] prices = {7, 6, 4, 3, 1};//0
        int result = solution.maxProfit(prices);
        MyUtils.print(MyUtils.ANSI_RED + result + MyUtils.ANSI_RESET);
    }

}

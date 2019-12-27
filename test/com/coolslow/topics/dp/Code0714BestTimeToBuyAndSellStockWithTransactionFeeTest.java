package com.coolslow.topics.dp;

import com.coolslow.datastruct.utils.MyUtils;
import com.coolslow.leetcode.topics.dp.Code0714BestTimeToBuyAndSellStockWithTransactionFee;
import org.junit.Test;

/**
 * 买卖股票的最佳时机含手续费
 * by MrThanksgiving
 */
public class Code0714BestTimeToBuyAndSellStockWithTransactionFeeTest {

    @Test
    public void testSolution() {
        Code0714BestTimeToBuyAndSellStockWithTransactionFee solution = new Code0714BestTimeToBuyAndSellStockWithTransactionFee();
        int[] prices = {1, 3, 2, 8, 4, 9};
        int result = solution.maxProfit(prices, 2);
        MyUtils.print(MyUtils.ANSI_RED + result + MyUtils.ANSI_RESET);
    }

}

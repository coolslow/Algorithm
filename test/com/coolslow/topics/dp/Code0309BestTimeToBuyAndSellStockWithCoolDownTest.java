package com.coolslow.topics.dp;

import com.coolslow.datastruct.utils.MyUtils;
import com.coolslow.leetcode.topics.dp.Code0309BestTimeToBuyAndSellStockWithCoolDown;
import org.junit.Test;

/**
 * 最佳买卖股票时机含冷冻期
 * by MrThanksgiving
 */
public class Code0309BestTimeToBuyAndSellStockWithCoolDownTest {


    @Test
    public void testSolution() {
        Code0309BestTimeToBuyAndSellStockWithCoolDown solution = new Code0309BestTimeToBuyAndSellStockWithCoolDown();
        int[] prices = {1, 2, 3, 0, 2};
//        int[] prices = {1, 2, 4};
        int result = solution.maxProfit(prices);
        MyUtils.print(MyUtils.ANSI_RED + result + MyUtils.ANSI_RESET);
    }

}

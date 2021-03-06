package com.coolslow.topics.dp;

import com.coolslow.datastruct.utils.MyUtils;
import com.coolslow.leetcode.topics.dp.Code123BestTimeToBuyAndSellStockIV;
import org.junit.Test;

/**
 * 买卖股票的最佳时机IV
 * by MrThanksgiving
 */
public class Code123BestTimeToBuyAndSellStockIVTest {


    @Test
    public void testSolution() {
        Code123BestTimeToBuyAndSellStockIV solution = new Code123BestTimeToBuyAndSellStockIV();
        int[] prices = {2, 4, 1};
        int k = 2;
//        File file = new File("src/com/coolslow/leetcode/topics/dp/test.txt");
//        int[] prices = MyIO.getIntArray(file.getAbsolutePath());
        int result = solution.maxProfit(k, prices);
        MyUtils.print(MyUtils.ANSI_RED + result + MyUtils.ANSI_RESET);
    }

}

package com.coolslow;

import com.coolslow.leetcode.top100.NO121_BestTimeToBuyAndSellStock;
import org.junit.Assert;
import org.junit.Test;

public class BestTimeToBuyAndSellStockTest {
    @Test
    public void shouldReturnCorrectBestTimeToByAndSellStockData() {
        int[] arr = new int[] {7, 1, 5, 3, 6, 4};
        int[] arr1 = new int[] {6, 5, 4, 3, 2, 1};
        int result = NO121_BestTimeToBuyAndSellStock.maxProfit(arr);
        int result1 = NO121_BestTimeToBuyAndSellStock.maxProfit(arr1);

        int result2 = NO121_BestTimeToBuyAndSellStock.maxProfitWithOnePass(arr);
        int result3 = NO121_BestTimeToBuyAndSellStock.maxProfitWithOnePass(arr1);

        Assert.assertEquals(5, result);
        Assert.assertEquals(0, result1);

        Assert.assertEquals(5, result2);
        Assert.assertEquals(0, result3);
    }
}

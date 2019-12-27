package com.coolslow.topics.dp;

import com.coolslow.datastruct.utils.MyUtils;
import com.coolslow.leetcode.topics.dp.Code0152MaximumProductSubArray;
import org.junit.Test;

/**
 * 乘积最大子序列
 * by MrThanksgiving
 */
public class Code0152MaximumProductSubArrayTest {

    @Test
    public void testSolution() {
        Code0152MaximumProductSubArray solution = new Code0152MaximumProductSubArray();
//        int[] prices = {2, 3, -2, 4};
        int[] prices = {-2, 0, -1};
        int result = solution.maxProduct(prices);
        MyUtils.print(MyUtils.ANSI_RED + result + MyUtils.ANSI_RESET);
    }

}

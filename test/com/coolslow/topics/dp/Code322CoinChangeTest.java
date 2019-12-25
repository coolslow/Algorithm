package com.coolslow.topics.dp;

import com.coolslow.datastruct.utils.MyUtils;
import com.coolslow.leetcode.topics.dp.Code322CoinChange;
import org.junit.Test;

import java.util.Arrays;

/**
 * 零钱兑换
 * by MrThanksgiving
 */
public class Code322CoinChangeTest {


    @Test
    public void testSolution() {
        Code322CoinChange solution = new Code322CoinChange();
        int[] coins = {1, 2, 5};//11
//        int[] coins = {2};//3
//        int[] coins = {2, 5, 10, 1}; //27
        int result = solution.coinChange(coins, 11);
        MyUtils.print(MyUtils.ANSI_RED + result + MyUtils.ANSI_RESET);
    }

}

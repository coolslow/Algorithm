package com.coolslow.topics.greedy;

import com.coolslow.datastruct.utils.MyUtils;
import com.coolslow.leetcode.topics.greedy.Code55JumpGame;
import org.junit.Test;

/**
 * by MrThanksgiving
 */
public class Code55JumpGameTest {

    @Test
    public void testSolution() {
        Code55JumpGame solution = new Code55JumpGame();
        int[] input = {2, 3, 1, 1, 4};
//        int[] input = {3, 2, 1, 0, 4};
        boolean result = solution.canJump(input);
        MyUtils.println(MyUtils.ANSI_RED + result + MyUtils.ANSI_RESET);
    }


    @Test
    public void testSolution2() {
        int[] coins = {1, 2};
        int amount = 3;
        int result = coinChange(coins, amount);
        MyUtils.println(MyUtils.ANSI_RED + result + MyUtils.ANSI_RESET);

    }

    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) return -1;
        int[] dp = new int[coins.length];
        return 0;
    }

}

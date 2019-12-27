package com.coolslow.topics.dp;

import com.coolslow.datastruct.utils.MyUtils;
import com.coolslow.leetcode.topics.dp.Code213HouseRobberII;
import org.junit.Test;


/**
 * 打家劫舍II
 * by MrThanksgiving
 */
public class Code213HouseRobberIITest {

    @Test
    public void testSolution() {
        Code213HouseRobberII solution = new Code213HouseRobberII();
        int[][] nums = {
                {1, 2, 3, 1},
                {2, 3, 2},
                {1, 1},
                {1, 2},
                {2, 1, 1, 2},
                {1, 2, 1, 1},
                {1, 7, 9, 2}
        };

        int result1 = solution.rob(nums[0]);
        MyUtils.println("第1个 max = " + MyUtils.ANSI_RED + result1 + " " + (result1 == 4) + MyUtils.ANSI_RESET);

        int result2 = solution.rob(nums[1]);
        MyUtils.println("第2个 max = " + MyUtils.ANSI_RED + result2 + " " + (result2 == 3) + MyUtils.ANSI_RESET);

        int result3 = solution.rob(nums[2]);
        MyUtils.println("第3个 max = " + MyUtils.ANSI_RED + result3 + " " + (result3 == 1) + MyUtils.ANSI_RESET);

        int result4 = solution.rob(nums[3]);
        MyUtils.println("第4个 max = " + MyUtils.ANSI_RED + result4 + " " + (result4 == 2) + MyUtils.ANSI_RESET);

        int result5 = solution.rob(nums[4]);
        MyUtils.println("第5个 max = " + MyUtils.ANSI_RED + result5 + " " + (result5 == 3) + MyUtils.ANSI_RESET);

        int result6 = solution.rob(nums[5]);
        MyUtils.println("第6个 max = " + MyUtils.ANSI_RED + result6 + " " + (result6 == 3) + MyUtils.ANSI_RESET);

        int result7 = solution.rob(nums[6]);
        MyUtils.println("第7个 max = " + MyUtils.ANSI_RED + result7 + " " + (result7 == 10) + MyUtils.ANSI_RESET);

    }


}

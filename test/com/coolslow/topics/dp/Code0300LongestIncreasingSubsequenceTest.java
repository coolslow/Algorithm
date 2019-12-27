package com.coolslow.topics.dp;

import com.coolslow.datastruct.utils.MyUtils;
import com.coolslow.leetcode.topics.dp.Code0300LongestIncreasingSubsequence;
import org.junit.Test;

/**
 * 最长上升子序列
 * by MrThanksgiving
 */
public class Code0300LongestIncreasingSubsequenceTest {

    @Test
    public void testSolution() {
        Code0300LongestIncreasingSubsequence solution = new Code0300LongestIncreasingSubsequence();
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
//        int[] nums = {4, 10, 4, 3, 8, 9};
        int result = solution.lengthOfLIS(nums);
        MyUtils.print(MyUtils.ANSI_RED + result + MyUtils.ANSI_RESET);
    }


}

package com.coolslow.leetcode.topics.dp;

import com.coolslow.datastruct.utils.MyUtils;
import org.junit.Test;

import java.util.Arrays;

/**
 * 最长上升子序列
 * by MrThanksgiving
 */
public class Code300LongestIncreasingSubsequence {

    /**
     * <pre>
     * 题目：
     *      给定一个无序的整数数组，找到其中最长上升子序列的长度。
     *
     * 示例:
     *      输入: [10,9,2,5,3,7,101,18]
     *      输出: 4
     *      解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
     *
     * 说明:
     *      可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
     *      你算法的时间复杂度应该为 O(n2) 。
     *
     * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
     * </pre>
     */

    public int lengthOfLIS(int[] nums) {
//         dp[i] =  以i点结尾的最长上升子序列的长度
//         dp[i] =  Math.max(dp[i-1] ... dp[0]) + 1;
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int count = nums.length;
        int[] dp = new int[count];
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 1; i < count; i++) {
            for (int j = i - 1; j >= 0; j--) {
                dp[i] = nums[i] > nums[j] ? Math.max(dp[j] + 1, dp[i]) : dp[i];
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }

    @Test
    public void testSolution() {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
//        int[] nums = {4, 10, 4, 3, 8, 9};
        int result = lengthOfLIS(nums);
        MyUtils.print(MyUtils.ANSI_RED + result + MyUtils.ANSI_RESET);
    }


}

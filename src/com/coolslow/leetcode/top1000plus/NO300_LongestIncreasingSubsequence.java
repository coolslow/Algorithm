package com.coolslow.leetcode.top1000plus;

import java.util.Arrays;

/**
 * 300. 最长上升子序列
 *
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 *
 * 示例:
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是[2,3,7,101]，它的长度是 4。
 * 说明:
 *
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为O(n^2) 。
 *
 */
class NO300_LongestIncreasingSubsequence {

    /**
     * 解法一：动态规划
     * 题解思路：
     *
     * 状态定义：
     * - dp[i]的值代表 nums 前 i 个数字的最长子序列长度。
     *
     * 转移方程：
     * - 设 j 属于区间 [0, i，考虑每轮计算新 dp[i] 时，做以下判断：
     * 1. 当 nums[i] > nums[j]时： nums[i] 可以接在 nums[j] 之后（此题要求严格递增），此情况下最长上升子序列长度为 dp[j] + 1；
     * 2. 当 nums[i] <= nums[j] 时： nums[i] 无法接在 nums[j] 之后，此情况上升子序列不成立，跳过。
     *
     * 上述所有1情况下计算出的dp[j] + 1的最大值，为直到 i 的最长上升子序列长度（即 dp[i]）。实现方式为遍历 j 时，每轮执行 dp[i] = max(dp[i], dp[j] + 1)。
     * 转移方程： dp[i] = max(dp[i], dp[j] + 1) for j in [0, i)。
     *
     * 初始状态
     * - dp[i] 所有元素置 1，含义是每个元素都至少可以单独成为子序列，此时长度都为 1。
     *
     * 返回值：
     * - 返回 dp 列表最大值，即可得到全局最长上升子序列长度。
     *
     * 复杂度分析：
     * 时间复杂度 O(N^2)： 遍历计算 dp 列表需 O(N)，计算每个 dp[i] 需 O(N)。
     * 空间复杂度 O(N) ： dp 列表占用线性大小额外空间。
     *
     */
    public static int lengthOfLISI(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        int res = 0;
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }

        return res;
    }

    public static int lengthOfLISII(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxans = 1;
        for (int i = 0; i < dp.length; i++) {
            int maxval = 0;
            for (int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) {
                    maxval = Math.max(maxval, dp[j]);
                }
            }
            dp[i] = maxval + 1;
            maxans = Math.max(maxans, dp[i]);
        }

        return maxans;
    }
}

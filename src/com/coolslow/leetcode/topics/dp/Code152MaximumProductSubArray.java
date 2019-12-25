package com.coolslow.leetcode.topics.dp;

/**
 * 乘积最大子序列
 * by MrThanksgiving
 */
public class Code152MaximumProductSubArray {

    /**
     * <pre>
     * 题目：
     *      给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
     *
     * 示例 1:
     *      输入: [2,3,-2,4]
     *      输出: 6
     *      解释: 子数组 [2,3] 有最大乘积 6。
     *
     * 示例 2:
     *      输入: [-2,0,-1]
     *      输出: 0
     *      解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
     * </pre>
     */
    public int maxProduct(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        // dp[i][j]
        //      dp[i][0]为以i位置结束的所有连续序列中乘积最小值
        //      dp[i][1]为以i位置结束的所有连续序列中乘积最大值

        int count = nums.length;
        int[][] dp = new int[count][2];
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];
        int max = nums[0];
        for (int i = 1; i < count; i++) {
            if (nums[i] > 0) {
                dp[i][1] = Math.max(dp[i - 1][1] * nums[i], nums[i]);
                dp[i][0] = Math.min(dp[i - 1][0] * nums[i], nums[i]);
            } else {
                dp[i][1] = Math.max(dp[i - 1][0] * nums[i], nums[i]);
                dp[i][0] = Math.min(dp[i - 1][1] * nums[i], nums[i]);
            }
            max = Math.max(dp[i][1], max);
        }
        return max;
    }


}

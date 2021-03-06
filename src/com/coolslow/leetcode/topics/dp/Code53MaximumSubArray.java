package com.coolslow.leetcode.topics.dp;

/**
 * 最大子序和
 * by MrThanksgiving
 */
public class Code53MaximumSubArray {

    /**
     * <pre>
     *
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     *
     * 示例:
     *      输入: [-2,1,-3,4,-1,2,1,-5,4],
     *      输出: 6
     *      解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
     *
     * </pre>
     */
    public int maxSubArray(int[] nums) {
        // dp[i] 以 i 结尾的所有子数组中，和最大的是多少？
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int count = nums.length;
        int[] dp = new int[count];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < count; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 1], nums[i]);
            max = Math.max(dp[i], max);
        }
        return max;
    }


}

package com.coolslow.leetcode.topics.dp;

import java.util.Arrays;

/**
 * 打家劫舍II
 * by MrThanksgiving
 */
public class Code213HouseRobberII {

    /**
     * <pre>
     * 题目：
     *      你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。
     *      这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。
     *      同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
     *
     *      给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
     *
     * 示例 1:
     *      输入: [2,3,2]
     *      输出: 3
     *      解释: 你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
     *
     * 示例 2:
     *      输入: [1,2,3,1]
     *      输出: 4
     *      解释: 你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。偷窃到的最高金额 = 1 + 3 = 4 。
     *
     * </pre>
     */
    public int rob(int[] nums) {

        // dp[i] = 偷窃到第i个房间时，获得的最高金额
        // dp[i] = Math.max(dp[i-2] ... 0 and dp[n-1] ... dp[i+2])   n为长度

        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int count = nums.length;
        return Math.max(
                maxRob(Arrays.copyOfRange(nums, 0, count - 1)),
                maxRob(Arrays.copyOfRange(nums, 1, count))
        );
    }

    private int maxRob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int count = nums.length;
        int[] dp = new int[count];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);
        for (int i = 2; i < count; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[count - 1];
    }


//    public int rob(int[] nums) {
//
//        // dp[i] = 偷窃到第i个房间时，获得的最高金额
//        // dp[i] = Math.max(dp[i-2] ... 0 and dp[n-1] ... dp[i+2])   n为长度
//
//        if (nums == null || nums.length == 0) {
//            return 0;
//        }
//        if (nums.length == 1) {
//            return nums[0];
//        }
//        if (nums.length == 2) {
//            return Math.max(nums[0], nums[1]);
//        }
//        int count = nums.length;
//        return Math.max(
//                maxRob(nums, 0, count - 1),
//                maxRob(nums, 1, count)
//        );
//    }
//
//    private int maxRob(int[] nums, int start, int end) {
//        if (nums == null || nums.length == 0) {
//            return 0;
//        }
//        if (nums.length == 1) {
//            return nums[0];
//        }
//        int[] dp = new int[nums.length];
//        dp[start] = nums[start];
//        dp[start + 1] = Math.max(dp[start], nums[start + 1]);
//        for (int i = start + 2; i < end; i++) {
//            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
//        }
//        return dp[end - 1];
//    }


}

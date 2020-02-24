package com.coolslow.leetcode.top100plus;

/**
 * NO.198 打家劫舍
 *
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金；
 * 影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 *
 * 示例 1:
 *
 *  输入: [1,2,3,1]
 *  输出: 4
 *  解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *       偷窃到的最高金额 = 1 + 3 = 4 。
 *
 * 示例 2:
 *
 * 输入: [2,7,9,3,1]
 * 输出: 12
 * 解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 *
 *
 */
public class NO198_HouseRobber {

    /**
     * 方法一：动态规划（第一种方法）
     *
     * 时间复杂度：O(n)。其中 n 为房子的数量。
     * 空间复杂度：O(1)。
     *
     * 思路：
     *      考虑所有可能的抢劫方案是十分困难的。自然的想法是首先从最简单的情况考虑：
     *      f(k) = 从前 k 个房间抢劫到的最大金额，Ai = 第 i 个房间的钱数。
     *
     *      先看 n = 1 的情况，则 f(1) = A1
     *      在看 n = 2 的情况，则 f(2) = Max(A1, A2)
     *      对于 n = 3 的情况，有两个选项：
     *      1. 抢第三个房子，将数额与第一个房子的金额相加。
     *      2. 不抢第三个房子，保持现有的最大金额。
     *
     *      显然想选出数额最大的选项的通用公式如下：
     *      f(k) = Max(f(k - 2) + Ak, f(k - 1))
     *
     * -------------------------------------------------------------------------
     * > 递推公式：dp[i] = max(dp[i - 2] + nums[i], dp[i - 1])
     * > 关键是dp[0]和dp[1]的初始化, dp[0]=nums[0], dp[1]要初始化成nums[0]和nums[1]中较大的那个
     * > 因为dp[i]的意义为打劫前i个所获取的最大值。
     *
     *
     * @param nums 给定的代表每家存放金额的数组
     * @return 返回最优的抢劫方案的结果
     */
    public static int rob(int[] nums) {

        int len = nums.length;
        if(len == 0) {
            return 0;
        }
        // 申请了一个长度为 len + 1 的数组
        int[] dp = new int[len + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for(int i = 2; i <= len; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[len];
    }

    /**
     * 时间复杂度：O(n)。其中 n 为房子的数量。
     * 空间复杂度：O(1)。
     *
     * @param nums 给定的代表每家存放金额的数组
     * @return 返回最优的抢劫方案的结果
     */
    public static int houseRobber(int[] nums) {
        int prevMax = 0;
        int currMax = 0;

        // 通过临时变量申请避免了空间复杂度为 O(n)，使空间复杂度为 O(1)
        for(int x: nums) {
            int temp = currMax;
            currMax = Math.max(prevMax + x, currMax);
            prevMax = temp;
        }

        return currMax;
    }
}

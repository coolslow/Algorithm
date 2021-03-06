package com.coolslow.leetcode.top1000plus;

import java.util.Arrays;

/**
 * NO.213 打家劫舍 II
 *
 * 规则：你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。
 * 同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 *
 * 示例 1:
 *
 * 输入: [2, 3, 2]
 * 输出: 3
 * 解释: 你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 *
 * 示例 2:
 *
 * 输入: [1, 2, 3, 1]
 * 输出: 4
 * 解释: 你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
 * 偷窃到的最高金额 = 1 + 3 = 4 。
 *
 * 此题是 NO 198. 打家劫舍 的拓展版本: 唯一的区别在于此题中的房间是环状排列的（即首尾相连）。而 NO 198. 题中的房间是单排排列的。
 * 环状排列的房子意味着第一个房子和最后一个房子中只能选择一个进行盗窃，因此，可以把此环状排列的房间问题变为两个单排排列的房子的问题：
 * 1. 在不偷窃第一个房子的情况下，获取最大的金额P1。范围表达式：[1, nums.length]
 * 2. 在不偷窃最后一个房子的前提下，获取最大金额P2。范围表达式：[0, nums.length - 1]
 * 3. 比较上述盗窃金额中较大的那一个：即 Max(P1, P2)即可。
 *
 * 状态定义：
 * - 设置动态规划列表 dp，dp[i]代表前i个房间再满足条件的前提下能偷窃到的最高金额。
 *
 * 转移方程：
 * - 设：有 n 个房间，前 n 间能偷窃到的最高金额是dp[n]，前 n-1 间房间能偷窃到的最高金额为 dp[n-1]，此时再在这些房间后添加一间房间，此房间存放的金额为num；
 * - 加一间房间后：由于不能强相邻的房间，这意味着抢第 n+1 间房间就不能抢第 n 间；那么前 n+1 间房能偷到的最高金额 dp[n+1] 一定是以下两种情况的较大值：
 *   1. 不抢第 n+1 个房间，此时等于前n个房间的最高金额，即：dp[n+1] = dp[n]
 *   2. 抢第 n+1 个房间，此时不能抢第n个房间，因此等于前 n-1 个房间的最高金额加上当前房间价值，即：dp[n+1] = dp[n-1] + num
 *
 * 此时需要思考：难道在前n间的最高金额dp[n]情况下，第n间房间一定被偷吗？回答是否定的。
 * - 假设第n间没有被偷，此时：dp[n] = dp[n-1]，此时： dp[n+1] 可以是： dp[n] + num，也可以是：dp[n-1] + num
 * - 假设第n间被偷，此时：dp[n+1] = dp[n] + num，但显然与题设条件矛盾：第n间房和第n+1间房不能同时被偷。
 * 因此，最终的状态转移方程为：dp[n+1] = max(dp[n], dp[n-1] + num);
 *
 * 空间及时间复杂度分析：
 * - 时间复杂度 O(N) ： 两次遍历 nums 需要线性时间；
 * - 空间复杂度 O(1) ： cur 和 pre 使用常数大小的额外空间。
 *
 * 题解参考：
 * - https://leetcode-cn.com/problems/house-robber-ii/solution/tong-yong-si-lu-tuan-mie-da-jia-jie-she-wen-ti-by-/
 *
 * ==============================================================================================
 * 对于众多的题解：其实可以将视为 NO.198 打家劫舍 的两种情况思考：
 * 对于第一个房间，存在偷与不偷两种情况：
 * 1. 如果第一个房间偷，则最后一个房间一定不偷。将最后一个房间的值记为0即可，以此数组为基准，运行198题代码。
 * 2. 对于第一个房间如果不偷的情况，则把第一个房间的值计为0，最后一家可偷，可不偷。再执行198题代码，再得到一个结果。
 * 3. 比较这两个结果，取最大值即可。
 * ==============================================================================================
 */

public class NO213_HouseRobberII {

    /**
     * 动态规划解题
     * @param nums 给定的代表房子的数组(首尾相连)
     * @return 返回可以偷窃到的最高金额
     */
    public static int houseRobII(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }

        if(nums.length == 1) {
            return nums[0];
        }

        int p1 = myRob(Arrays.copyOfRange(nums, 0, nums.length - 1));
        int p2 = myRob(Arrays.copyOfRange(nums, 1, nums.length));

        return Math.max(p1, p2);
    }

    private static int myRob(int[] nums) {
        int pre = 0, cur = 0, tmp;

        for(int num: nums) {
            tmp = cur;
            cur = Math.max(pre + num, cur);
            pre = tmp;
        }

        return cur;
    }
}

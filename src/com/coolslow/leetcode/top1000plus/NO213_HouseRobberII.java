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
 * 空间及时间复杂度分析：
 * - 时间复杂度 O(N) ： 两次遍历 nums 需要线性时间；
 * - 空间复杂度 O(1) ： cur 和 pre 使用常数大小的额外空间。
 */

@Deprecated
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

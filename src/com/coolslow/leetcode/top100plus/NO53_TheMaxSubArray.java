package com.coolslow.leetcode.top100plus;

/**
 * 53. 最大子序和
 *
 * 给定一个整数数组nums，找到一个具有最大和的连续子数组（子数组至少包含一个元素），返回其最大和。
 *
 * 示例:
 *  输入: [-2,1,-3,4,-1,2,1,-5,4],
 *  输出: 6
 *  解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 * 进阶:
 *  如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 */
public class NO53_TheMaxSubArray {

    /**
     * 方法一：分治法
     * 分治法解体套路：
     *  1. 定义基本情况
     *  2. 将问题分解为子问题并递归解决
     *  3. 合并子问题的解以获取原始问题的解
     *
     * 当最大子数组有 n 个数字时：
     *  1. 若 n = 1，返回此元素
     *  2. left_sum 为最大子数组的前 n/2 个元素，在索引为 (left + right)/2 的元素属于左子数组。
     *  3. right_sum 为最大子数组的右子数组，为最后 n/2 的元素。
     *  4. cross_num 是包含左右子数组且含索引 (left + right)/2 的最大值。
     *
     *
     * @param nums 输入的数组
     * @return 返回连续子数组的最大和
     */
    public static int maxSubArray(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private static int helper(int[] nums, int left, int right) {
        if(left == right) {
            return nums[left];
        }

        int p = (left + right)/2;

        // 递归处理左子数组
        int leftSum = helper(nums, left, p);
        // 递归处理右子数组
        int rightSum = helper(nums, p + 1, right);
        // 处理包含左子数组、右子数组和包含左右子数组且含索引 (left + right)/2 的最大值
        int crossSum = crossSum(nums, left, right, p);

        // 比较左子数组、右子数组以及包含中间值的数组
        return Math.max(Math.max(leftSum, rightSum), crossSum);
    }

    private static int crossSum(int[] nums, int left, int right, int p) {
        if(left == right) {
            return nums[left];
        }
        // 设初始左子数组和为最小Int值
        int leftSubSum = Integer.MIN_VALUE;
        int currSum = 0;
        // 这里用 --i的目的是为了防止数组越界
        for(int i = p; i > left - 1; --i) {
            currSum += nums[i];
            leftSubSum = Math.max(leftSubSum, currSum);
        }

        int rightSubSum = Integer.MIN_VALUE;
        currSum = 0;

        // 这里用 ++i的目的也是为了防止数组越界
        for(int i = p + 1; i < right + 1; ++i) {
            currSum += nums[i];
            rightSubSum = Math.max(rightSubSum, currSum);
        }

        return leftSubSum + rightSubSum;
    }

    /**
     * 方法二：更好的动态规划解法
     * @param nums 输入的数组
     * @return 返回连续子数组的最大和
     */
    public static int maxSubArrayShorter(int[] nums) {
        // 先假设最大的子数组为数组的第一个数
        // 这样就可以忽略数组只有一个元素的极端情况
        int prev = nums[0];
        int max = prev;

        for(int i = 1; i < nums.length; i++) {
            prev = Math.max(prev + nums[i], nums[i]);
            max = Math.max(max, prev);
        }

        return max;
    }
}

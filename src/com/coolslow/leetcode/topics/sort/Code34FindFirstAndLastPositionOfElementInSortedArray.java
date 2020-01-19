package com.coolslow.leetcode.topics.sort;

/**
 * 在排序数组中查找元素的第一个和最后一个位置
 * by MrThanksgiving
 */
public class Code34FindFirstAndLastPositionOfElementInSortedArray {

    /**
     * <pre>
     * 题目：
     *      给定一个按照升序排列的整数数组 nums，和一个目标值 target。
     *      找出给定目标值在数组中的开始位置和结束位置。
     *      你的算法时间复杂度必须是 O(log n) 级别。
     *      如果数组中不存在目标值，返回 [-1, -1]。
     *
     * 示例 1:
     *      输入: nums = [5,7,7,8,8,10], target = 8
     *      输出: [3,4]
     *
     * 示例 2:
     *      输入: nums = [5,7,7,8,8,10], target = 6
     *      输出: [-1,-1]
     *
     * </pre>
     */
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        if (nums == null || nums.length == 0) return result;
        result[0] = lowerBound(nums, target);
        result[1] = higherBound(nums, target);
        return result;
    }

    private int lowerBound(int[] nums, int target) {
        int l = 0, r = nums.length - 1, m = -1;
        while (l <= r) {
            m = l + (r - l) / 2;
            if (nums[m] < target) l = m + 1;
            else if ((nums[m] > target)) r = m - 1;
            else {
                if (m - 1 >= 0 && nums[m - 1] == target) r = m - 1;
                else return m;
            }
        }
        return -1;
    }

    private int higherBound(int[] nums, int target) {
        int l = 0, r = nums.length - 1, m = -1;
        while (l <= r) {
            m = l + (r - l) / 2;
            if (nums[m] > target) r = m - 1;
            else if (nums[m] < target) l = m + 1;
            else {
                if (m + 1 < nums.length && nums[m + 1] == target) l = m + 1;
                else return m;
            }
        }
        return -1;
    }

}

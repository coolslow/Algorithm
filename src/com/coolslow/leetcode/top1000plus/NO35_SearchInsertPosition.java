package com.coolslow.leetcode.top1000plus;

/**
 * 35. 搜索插入位置
 *
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 *
 * 示例 1:
 *
 * 输入: [1, 3, 5, 6], 5
 * 输出: 2
 * 示例 2:
 *
 * 输入: [1, 3, 5, 6], 2
 * 输出: 1
 * 示例 3:
 *
 * 输入: [1, 3, 5, 6], 7
 * 输出: 4
 * 示例 4:
 *
 * 输入: [1, 3, 5, 6], 0
 * 输出: 0
 *
 * 可以假设数组中无重复元素。
 *
 */
public class NO35_SearchInsertPosition {

    /**
     * 解法：二分查找(最优解法)
     *  - 如果该题目暴力解决的话需要 O(n) 的时间复杂度，但是如果二分的话则可以降低到 O(logn) 的时间复杂度
     *  - 整体思路和普通的二分查找几乎没有区别，先设定左侧下标 left 和右侧下标 right，再计算中间下标 mid
     *  - 每次根据 nums[mid] 和 target 之间的大小进行判断，相等则直接返回下标，nums[mid] < target 则 left 右移，nums[mid] > target 则 right 左移
     *  - 查找结束如果没有相等值则返回 left，该值为插入位置
     *  - 时间复杂度：O(logn)
     *
     *
     * @param nums 给定的有序数组
     * @param target 目标整数
     * @return 如果在数组中找到目标值，返回找到的目标值的数组下标，否则返回被按顺序插入的位置
     */
    public static int searchInsertPosition(int[] nums, int target) {
        // 指向数组左侧的指针
        int left = 0;
        // 指向数组右侧的指针，数组下标从0开始，因此需要减1
        int right = nums.length - 1;

        while(left <= right) {
            // 中间下标
            int mid = (left + right) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }
}

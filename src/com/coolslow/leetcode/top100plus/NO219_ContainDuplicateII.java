package com.coolslow.leetcode.top100plus;

/**
 * 219. 存在重复数 II
 *
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。
 * 示例 1:
 *
 * 输入: nums = [1, 2, 3, 1], k = 3
 * 输出: true
 *
 * 示例 2:
 *
 * 输入: nums = [1, 0, 1, 1], k = 1
 * 输出: true
 *
 * 示例 3:
 *
 * 输入: nums = [1, 2, 3, 1, 2, 3], k = 2
 * 输出: false
 *
 */
public class NO219_ContainDuplicateII {

    /**
     * 方法一：线性搜索（超时）
     *
     *
     *
     *
     * @param nums 给定的数组
     * @param k 给定的整数k
     * @return 返回是否满足题干要求，true为满足，false为不满足
     */
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        for(int i = 0; i < nums.length; i++) {
            for(int j = Math.max(i - k, 0); j < i; j++) {
                if(nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}

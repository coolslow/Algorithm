package com.coolslow.leetcode.top1000plus;

import java.util.HashSet;

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
     * @param nums 给定的数组
     * @param k 给定的整数k
     * @return 返回是否满足题干要求，true为满足，false为不满足
     */
    public static boolean containsDuplicateLinearSearch(int[] nums, int k) {
        for(int i = 0; i < nums.length; i++) {
            for(int j = Math.max(i - k, 0); j < i; j++) {
                if(nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 方法二：哈希
     *
     * 思路：
     *  > 维护一个hash表，里面始终最多包含k个元素，当出现重复值时，则说明在k个距离内存在重复元素
     *  > 每次遍历一个元素则将其加入哈希表中，如果哈希表的大小大于 k，则移除最前面的数字
     *  > 时间复杂度：O(n)，n 为数组长度
     *
     * @param nums 给定的数组
     * @param k 给定的整数k
     * @return 返回是否满足题干要求，true为满足，false为不满足
     */
    public static boolean containsDuplicateWithHash(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
            if(set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }
}

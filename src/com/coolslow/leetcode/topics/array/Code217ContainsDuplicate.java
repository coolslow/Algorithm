package com.coolslow.leetcode.topics.array;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 是否存在重复元素
 * by MrThanksgiving
 */
public class Code217ContainsDuplicate {

    /**
     * <pre>
     * 题目：
     *      给定一个整数数组，判断是否存在重复元素。
     *      如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
     *
     * 示例 1:
     *      输入: [1,2,3,1]
     *      输出: true
     *
     * 示例 2:
     *      输入: [1,2,3,4]
     *      输出: false
     *
     * 示例 3:
     *      输入: [1,1,1,3,3,4,3,2,4,2]
     *      输出: true
     *
     * </pre>
     */
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1)
            return false;
        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (hashSet.contains(nums[i]))
                return true;
            hashSet.add(nums[i]);
        }
        return false;
    }

    public boolean containsDuplicate2(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1)
            return false;
        Arrays.sort(nums);
        int temp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (temp == nums[i])
                return true;
            temp = nums[i];
        }
        return false;
    }

}

package com.coolslow.leetcode.topics.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 * by MrThanksgiving
 */
public class Code1TwoSum {

    /**
     * <pre>
     * 题目：
     *      给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     *      你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     *
     * 示例:
     *      给定 nums = [2, 7, 11, 15], target = 9
     *      因为 nums[0] + nums[1] = 2 + 7 = 9
     *      所以返回 [0, 1]
     *
     * </pre>
     */
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0 || nums.length == 1) return new int[0];
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.get(target - nums[i]) != null) {
                result[0] = map.get(target - nums[i]);
                result[1] = i;
                return result;
            }
            map.put(nums[i], i);
        }
        return result;
    }

}

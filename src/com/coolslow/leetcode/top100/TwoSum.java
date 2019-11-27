package com.coolslow.leetcode.top100;

import java.util.HashMap;
import java.util.Map;

/**
 * 1、两数之和
 * 给定一个整数数组 nums 和一个目标值 target, 请在该数组中找出和为目标值的那 "两个" 整数，并返回他们的数组下标
 * 可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中童谣的元素：
 *
 * 示例：
 *      给定 nums = [2, 7, 11, 15], target = 9
 *      因为 nums[0] + nums[1] = 2 + 7 = 9
 *      所以返回 [0, 1]
 *
 * 相关标签：数组、哈希表
 */

public class TwoSum {
    // 暴力解决办法， 时间复杂度为O(n^2)
    public static int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[j] == target - nums[i]) {
                    return new int[] {i, j};
                }
            }
        }
        return new int[] {};
    }

    // 利用hash map空间换时间，时间复杂度为O(n),但空间复杂度也为O(n)
    public static int[] twoSumWithHashMap(int[] nums, int target) {
        // 声明一个HashMap
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++ ) {
            map.put(nums[i], i);
        }

        for(int i = 0; i < nums.length; i++) {
            int tmp = target - nums[i];
            if(map.containsKey(tmp) && map.get(tmp) != i ) {
                return new int[] { i, map.get(tmp) };
            }
        }
        return new int[] {};
    }

    // 一趟 Hash 遍历实现查找
    public static int[] twoSumWithOnePassHashMap(int[] nums, int target) {
        // 声明一个HashMap
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            int tmp = target - nums[i];
            if(map.containsKey(tmp)) {
                return new int[] { map.get(tmp), i };
            }

            map.put(nums[i], i);
        }
        return new int[] {};
    }
}

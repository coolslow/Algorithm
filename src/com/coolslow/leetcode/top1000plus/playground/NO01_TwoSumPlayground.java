package com.coolslow.leetcode.top1000plus.playground;

import com.coolslow.common.Playground;
import com.coolslow.common.Solution;
import com.coolslow.common.Topics;

import java.util.HashMap;
import java.util.Map;

@Playground(name = "两数之和", rank = Playground.Difficulty.Easy)
public class NO01_TwoSumPlayground {

    /**
     * 暴力解法，时间复杂度为O(n^2)
     * @param nums 给定的数组
     * @param target 目标值
     * @return 返回满足目标值的数组中元素的下标
     */
    @Solution(desc = "解法1：两数之和 - 暴力解法")
    @Topics(tags = Topics.Tags.Array)
    public static int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++) {
            for(int j= i + 1; j < nums.length; j++) {
                if(nums[j] == target - nums[i]) {
                    return new int[] {i, j};
                }
            }
        }
        
        return new int[] {};
    }
    
    /**
     * 使用HashMap遍历存储数组中的数据，再逐个比较 O(n)
     * @param nums 给定的数组
     * @param target 目标值
     * @return 返回满足目标值的数组中元素的下标
     */
    @Solution(desc = "解法2：两数之和 - HasMap两次for循环")
    @Topics(tags = Topics.Tags.Array)
    public static int[] twoSumWithHashMap(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for(int j = 0; j < nums.length; j++) {
            int temp = target - nums[j];
            // 在HashMap中包含 temp 满足target - nums[j]的数且这个数下标不是j
            if(map.containsKey(temp) && map.get(temp) != j) {
                return new int[] {j, map.get(temp)};
            }
        }

        return new int[] {};
    }

    /**
     * 使用HashMap一次遍历存储数组中的数据并返回对应的数组下标 O(n)
     * @param nums 给定的数组
     * @param target 目标值
     * @return 返回满足目标值的数组中元素的下标
     */
    @Solution(desc = "解法3：两数之和 - HasMap一次for循环")
    @Topics(tags = Topics.Tags.Array)
    public static int[] twoSumWithOnePassHashMap(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++) {
            int tmp = target - nums[i];
            if(map.containsKey(tmp)) {
                return new int[] {map.get(tmp), i};
            }
            map.put(nums[i], i);
        }
        return new int[] {};
    }

    public static int[] twoSumInPlayground(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (target == nums[i] + nums[j]) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }


























}

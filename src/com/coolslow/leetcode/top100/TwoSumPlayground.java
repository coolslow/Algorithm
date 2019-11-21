package com.coolslow.leetcode.top100;

import com.coolslow.common.Playground;
import com.coolslow.common.Solution;
import com.coolslow.common.Topics;

import java.util.HashMap;
import java.util.Map;

@Playground(name = "两数之和", rank = Playground.Difficulty.Easy)
public class TwoSumPlayground {

    /**
     * 暴力解法，时间复杂度为O(n^2)
     * @param nums
     * @param target
     * @return
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
     * @param nums
     * @param target
     * @return
     */
    @Solution(desc = "两数之和 - HasMap两次for循环")
    @Topics(tags = Topics.Tags.Array)
    public static int[] twoSumWithHashMap(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for(int j = 0; j < nums.length; j++) {
            int temp = target - nums[j];
            if(map.containsKey(temp) && map.get(temp) != j) {
                return new int[] {j, map.get(temp)};
            }
        }

        return new int[] {};
    }

    /**
     * 使用HashMap一次遍历存储数组中的数据并返回对应的数组下标 O(n)
     * @param nums
     * @param target
     * @return
     */
    @Solution(desc = "两数之和 - HasMap两次for循环")
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
}

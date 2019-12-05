package com.coolslow.leetcode.top100.playground;

import com.coolslow.common.Playground;

import java.util.HashMap;
import java.util.Map;

@Playground(name = "两数相加", rank = Playground.Difficulty.Medium)
public class AddTwoNumbersPlayground {

    /**
     * 暴力解法
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if(nums[j] == target - nums[i]) {
                    return new int[] {i, j};
                }
            }
        }
        return new int[] {};
    }

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
}

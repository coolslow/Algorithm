package com.coolslow.leetcode.top100;

import java.util.HashMap;
import java.util.Map;

public class TwoSumPlayground {

    /**
     * 使用HashMap一次遍历存储数组中的数据，再逐个比较
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
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

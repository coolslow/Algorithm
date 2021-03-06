package com.coolslow.leetcode.top1000plus.playground;

import com.coolslow.common.Playground;

@Playground(name = "删除排序数组中的重复项", rank = Playground.Difficulty.Easy)
public class NO26_RemoveDuplicateFromSortedArrayPlayground {

    // 数组去除重复数，返回不重复的数组项的总数
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[count] != nums[i]) {
                count++;
                nums[count] = nums[i];
            }
        }
        return count + 1;
    }
}
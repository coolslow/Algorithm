package com.coolslow.leetcode.top100;

import com.coolslow.common.Playground;

@Playground
public class RemoveDuplicateFromSortedArrayPlayground {

    // 数组去除重复数，返回不重复的数组项的总数
    public static int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        int count = 0;
        for(int i = 1; i < nums.length; i++) {
            if(nums[count] != nums[i]) {
                count++;
                nums[count] = nums[i];
            }
        }
        return count + 1;
    }
}

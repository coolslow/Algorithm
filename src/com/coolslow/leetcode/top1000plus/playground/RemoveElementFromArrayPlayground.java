package com.coolslow.leetcode.top1000plus.playground;

import com.coolslow.common.Playground;

@Playground(name = "移除元素", rank = Playground.Difficulty.Easy)
public class RemoveElementFromArrayPlayground {

    public static int removeElement(int[] nums, int val) {
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != val) {
                nums[count] = nums[i];
                count++;
            }
        }
        return count;
    }
}

package com.coolslow.leetcode.sort;

public class BubbleSort {

    public static int[] bubbleSort(int[] nums) {
        if(nums.length == 0) {
            return nums;
        }

        for(int i = 0; i < nums.length - 1; i++) {
            for(int j = 0; j < nums.length - 1 - i; j++) {
                if(nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }

        return nums;
    }
}

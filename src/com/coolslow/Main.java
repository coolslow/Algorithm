package com.coolslow;

import com.coolslow.leetcode.top100.TwoSum;

public class Main {

    public static void main(String[] args) {
	    // write your code here
        int[] nums = new int[] { 2, 7, 11, 15 };
        int target = 9;
        int[] res = TwoSum.twoSum(nums, target);
        int[] res1 = TwoSum.twoSumWithHashMap(nums, target);
        System.out.println(res);
        System.out.println(res1);
    }
}


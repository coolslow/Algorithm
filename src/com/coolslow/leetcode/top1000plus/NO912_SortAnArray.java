package com.coolslow.leetcode.top1000plus;

import java.util.Arrays;

/**
 * 912. 排序数组
 *
 * 给你一个整数数组 nums，请你将该数组升序排列。
 *
 * 示例 1：
 * 输入：nums = [5,2,3,1]
 * 输出：[1,2,3,5]
 *
 * 示例 2：
 * 输入：nums = [5,1,1,2,0,0]
 * 输出：[0,0,1,1,2,5]
 *  
 * 提示：
 * 1 <= nums.length <= 50000
 * -50000 <= nums[i] <= 50000
 *
 *
 * 维基百科--排序算法参考：https://zh.wikipedia.org/wiki/%E6%8E%92%E5%BA%8F%E7%AE%97%E6%B3%95
 *
 */
public class NO912_SortAnArray {

    /**
     * 用Java自带的排序算法
     * @param nums 给定的无序数字
     * @return 排序后的数字
     */
    public int[] sortArray(int[] nums) {
        Arrays.sort(nums);
        return nums;
    }
}

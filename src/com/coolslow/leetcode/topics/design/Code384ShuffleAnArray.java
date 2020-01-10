package com.coolslow.leetcode.topics.design;

import java.util.Random;

/**
 * 打乱数组
 * by MrThanksgiving
 */
public class Code384ShuffleAnArray {

    /**
     * <pre>
     * 题目：
     *      打乱一个没有重复元素的数组。
     *
     * 示例:
     *      // 以数字集合 1, 2 和 3 初始化数组。
     *      int[] nums = {1,2,3};
     *      Solution solution = new Solution(nums);
     *
     *      // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。
     *      solution.shuffle();
     *
     *      // 重设数组到它的初始状态[1,2,3]。
     *      solution.reset();
     *
     *      // 随机返回数组[1,2,3]打乱后的结果。
     *      solution.shuffle();
     *
     * </pre>
     */
    private int[] nums;
    private int[] origins;
    private Random random = new Random();

    public Code384ShuffleAnArray(int[] nums) {
        this.nums = nums;
        origins = nums.clone();
    }

    public int[] shuffle() {
        for (int i = 0; i < nums.length; i++) {
            swap(i, nums.length);
        }
        return nums;
    }

    private void swap(int s, int e) {
        int i = s + random.nextInt(e - s);
        int t = nums[s];
        nums[s] = nums[i];
        nums[i] = t;
    }

    public int[] reset() {
        nums = origins.clone();
        return nums;
    }

}

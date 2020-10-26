package com.coolslow.leetcode.top1000plus;

/**
 * 1365. 有多少小于当前数字的数字
 * 给你一个数组nums，对于其中每个元素nums[i]，请你统计数组中比它小的所有数字的数目。
 *
 * 换而言之，对于每个nums[i]你必须计算出有效的j的数量，其中 j 满足j != i 且 nums[j] < nums[i]。
 * 以数组形式返回答案。
 *
 * 示例 1：
 * ------------------------------------------------
 * 输入：nums = [8,1,2,2,3]
 * 输出：[4,0,1,1,3]
 * 解释：
 * 对于 nums[0]=8 存在四个比它小的数字：（1，2，2 和 3）。
 * 对于 nums[1]=1 不存在比它小的数字。
 * 对于 nums[2]=2 存在一个比它小的数字：（1）。
 * 对于 nums[3]=2 存在一个比它小的数字：（1）。
 * 对于 nums[4]=3 存在三个比它小的数字：（1，2 和 2）。
 *
 *
 * 示例 2：
 * ------------------------------------------------
 * 输入：nums = [6,5,4,8]
 * 输出：[2,1,0,3]
 *
 *
 * 示例 3：
 * ------------------------------------------------
 * 输入：nums = [7,7,7,7]
 * 输出：[0,0,0,0]
 *
 */
public class NO1365_HowManyNumbersAreSmallerThanTheCurrentNumber {

    /**
     * 解法一：暴力法
     * 时间复杂度 O(n^2)，空间复杂度 O(n)
     */
    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];

        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++) {
                // 下标相等的时候跳过，否则会导致重复比较
                if(i == j) {
                    continue;
                }

                if(nums[i] > nums[j]) {
                    res[i]++;
                }
            }
        }
        return res;
    }
}

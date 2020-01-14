package com.coolslow.leetcode.topics.array;

/**
 * 递增的三元子序列
 * by MrThanksgiving
 */
public class Code334IncreasingTripletSubsequence {

    /**
     * <pre>
     * 题目：
     *      给定一个未排序的数组，判断这个数组中是否存在长度为 3 的递增子序列。
     *
     *      数学表达式如下:
     *      如果存在这样的 i, j, k,  且满足 0 ≤ i < j < k ≤ n-1，
     *      使得 arr[i] < arr[j] < arr[k] ，返回 true ; 否则返回 false 。
     *      说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1) 。
     *
     * 示例 1:
     *      输入: [1,2,3,4,5]
     *      输出: true
     *
     * 示例 2:
     *      输入: [5,4,3,2,1]
     *      输出: false
     *
     * </pre>
     */
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3)
            return false;
        int[] increasing = new int[]{nums[0], Integer.MAX_VALUE, Integer.MAX_VALUE};
        for (int num : nums) {
            if (increasing[0] >= num)
                increasing[0] = num;
            else if (increasing[1] >= num)
                increasing[1] = num;
            else
                return true;
        }
        return false;
    }

}

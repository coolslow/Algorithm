package com.coolslow.leetcode.topics.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * by MrThanksgiving
 */
public class Code78Subsets {

    /**
     * <pre>
     * 题目：
     *      给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
     *
     * 说明：
     *      解集不能包含重复的子集。
     *
     * 示例:
     *      输入: nums = [1,2,3]
     *      输出:
     *      [
     *        [3],
     *        [1],
     *        [2],
     *        [1,2,3],
     *        [1,3],
     *        [2,3],
     *        [1,2],
     *        []
     *      ]
     *
     * </pre>
     */
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        helper(nums, 0, new LinkedList<>());
        return result;
    }

    public void helper(int[] nums, int index, LinkedList<Integer> list) {
        if (index > nums.length) {
            return;
        }
        result.add(new ArrayList<>(list));
        for (int i = index; i < nums.length; i++) {
            list.addLast(nums[i]);
            helper(nums, i + 1, list);
            list.removeLast();
        }
    }

}

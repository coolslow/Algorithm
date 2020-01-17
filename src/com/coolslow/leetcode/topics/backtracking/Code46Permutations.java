package com.coolslow.leetcode.topics.backtracking;

import java.util.*;

/**
 * 全排列
 * by MrThanksgiving
 */
public class Code46Permutations {

    /**
     * <pre>
     * 题目：
     *      给定一个没有重复数字的序列，返回其所有可能的全排列。
     *
     * 示例:
     *      输入: [1,2,3]
     *      输出:
     *      [
     *        [1,2,3],
     *        [1,3,2],
     *        [2,1,3],
     *        [2,3,1],
     *        [3,1,2],
     *        [3,2,1]
     *      ]
     *
     * </pre>
     */
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) return result;
        boolean[] visited = new boolean[nums.length];
        LinkedList<Integer> list = new LinkedList<>();
        helper(nums, list, visited);
        return result;
    }

    private void helper(int[] nums, LinkedList<Integer> list, boolean[] visited) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                list.addLast(nums[i]);
                helper(nums, list, visited);
                visited[i] = false;
                list.removeLast();
            }
        }

    }

}

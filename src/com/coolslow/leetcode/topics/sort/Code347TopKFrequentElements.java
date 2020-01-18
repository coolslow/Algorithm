package com.coolslow.leetcode.topics.sort;

import java.util.*;

/**
 * 前 K 个高频元素
 * by MrThanksgiving
 */
public class Code347TopKFrequentElements {

    /**
     * <pre>
     * 题目：
     *      给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
     *
     * 示例 1:
     *      输入: nums = [1,1,1,2,2,3], k = 2
     *      输出: [1,2]
     *
     * 示例 2:
     *      输入: nums = [1], k = 1
     *      输出: [1]
     *
     * 说明：
     *      你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
     *      你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
     *
     * </pre>
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
        LinkedList<Integer> result = new LinkedList<>();
        if (nums == null || nums.length == 0) return result;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        Queue<Integer> queue = new PriorityQueue<>(Comparator.comparing(map::get));
        for (Integer key : map.keySet()) {
            queue.add(key);
            if (queue.size() > k) queue.poll();
        }
        while (!queue.isEmpty()) {
            result.addFirst(queue.poll());
        }
        return result;
    }

}

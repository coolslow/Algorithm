package com.coolslow.leetcode.topics.array;

import java.util.PriorityQueue;

/**
 * 数组中的第K个最大元素
 * by MrThanksgiving
 */
public class Code0215KthLargestElementInAnArray {

    /**
     * <pre>
     * 题目：
     *      在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
     *
     * 示例 1:
     *      输入: [3,2,1,5,6,4] 和 k = 2
     *      输出: 5
     *
     * 示例 2:
     *      输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
     *      输出: 4
     *
     * 说明:
     *      你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
     * </pre>
     */
    public int findKthLargest2(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int count = nums.length;
        PriorityQueue<Integer> queue = new PriorityQueue<>(k);
        queue.offer(nums[0]);
        for (int i = 1; i < count; i++) {
            queue.offer(nums[i]);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.remove();
    }


    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        mergeSort(nums);
        for (int i = 0; i < k; i++) {
            if (i == k - 1) {
                return nums[k - 1];
            }
        }
        return 0;
    }


    public void mergeSort(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return;
        }
        int count = nums.length;
        int step = 1;
        while (step < count) {
            for (int i = 0; i + step < count; i = i + 2 * step) {
                int s = i;
                int m = i + step;
                int e = i + 2 * step - 1;
                if (e >= count) {
                    e = count - 1;
                }
                merge(nums, s, m, e);
            }
            step = 2 * step;
        }
    }

    private void merge(int[] nums, int start, int mid, int end) {
        int[] contain = new int[end - start + 1];
        int s = start;
        int m = mid;
        int k = 0;
        while (s < mid && m <= end) {
            contain[k++] = nums[s] < nums[m] ? nums[m++] : nums[s++];
        }
        while (s < mid)
            contain[k++] = nums[s++];
        while (m <= end)
            contain[k++] = nums[m++];
        for (int i = 0; i < k; i++) {
            nums[start + i] = contain[i];
        }
    }


}

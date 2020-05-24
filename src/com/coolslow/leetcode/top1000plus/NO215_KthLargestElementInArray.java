package com.coolslow.leetcode.top1000plus;

import java.util.PriorityQueue;

/**
 * 数组中的第K个最大元素
 *
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 *
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 */
public class NO215_KthLargestElementInArray {

    /**
     * 方法一：排序
     *
     * 最朴素的方法是先对数组进行排序，再返回倒数第 k 个元素，就像 Python 中的 sorted(nums)[-k]。
     * 算法的时间复杂度为 O(NlogN)，空间复杂度为 O(1)。
     *
     */

    /**
     * 方法二：堆
     *
     * 思路是创建一个大顶堆，将所有数组中的元素加入堆中，并保持堆的大小小于等于k。这样堆中就保留了前k个最大的元素。
     * 因此，堆顶的元素就是正确答案。
     *
     * 时间复杂度：O(NlogK)。
     * 空间复杂度 : O(k)，用于存储堆元素。
     */
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((n1, n2) -> n1 - n2);

        for(int n: nums) {
            heap.add(n);
            if(heap.size() > k) {
                heap.poll();
            }
        }
        return heap.poll();
    }
}

package com.coolslow.leetcode.topics.array;

import java.util.*;

/**
 * 两个数组的交集 II
 * by MrThanksgiving
 */
public class Code350IntersectionOfTwoArraysII {

    /**
     * <pre>
     * 题目：
     *      给定两个数组，编写一个函数来计算它们的交集。
     * 示例 1:
     *      输入: nums1 = [1,2,2,1], nums2 = [2,2]
     *      输出: [2,2]
     * 示例 2:
     *      输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     *      输出: [4,9]
     * 说明：
     *      输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
     *      我们可以不考虑输出结果的顺序。
     * 进阶:
     *      如果给定的数组已经排好序呢？你将如何优化你的算法？
     *      如果 nums1 的大小比 nums2 小很多，哪种方法更优？
     *      如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
     *
     * </pre>
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0) return new int[0];
        if (nums2 == null || nums2.length == 0) return new int[0];
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int n1 = 0;
        int n2 = 0;
        List<Integer> intersect = new ArrayList<>();
        while (n1 < nums1.length && n2 < nums2.length) {
            if (nums1[n1] < nums2[n2]) {
                n1++;
                continue;
            }
            if (nums1[n1] > nums2[n2]) {
                n2++;
                continue;
            }
            intersect.add(nums1[n1]);
            n1++;
            n2++;
        }
        int[] result = new int[intersect.size()];
        for (int i = 0; i < intersect.size(); i++)
            result[i] = intersect.get(i);
        return result;
    }

}

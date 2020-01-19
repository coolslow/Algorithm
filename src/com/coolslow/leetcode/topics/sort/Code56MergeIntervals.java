package com.coolslow.leetcode.topics.sort;

import java.util.*;
import java.util.stream.Stream;

/**
 * 合并区间
 * by MrThanksgiving
 */
public class Code56MergeIntervals {

    /**
     * <pre>
     * 题目：
     *      给出一个区间的集合，请合并所有重叠的区间。
     *
     * 示例 1:
     *      输入: [[1,3],[2,6],[8,10],[15,18]]
     *      输出: [[1,6],[8,10],[15,18]]
     *      解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
     *
     * 示例 2:
     *      输入: [[1,4],[4,5]]
     *      输出: [[1,5]]
     *      解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
     *
     * </pre>
     */
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return new int[0][0];
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        LinkedList<int[]> merged = new LinkedList<>();
        for (int[] ints : intervals) {
            if (merged.isEmpty() || merged.getLast()[1] < ints[0])
                merged.addLast(ints);
            else
                merged.getLast()[1] = Math.max(merged.getLast()[1], ints[1]);
        }
        return merged.toArray(new int[0][0]);
    }


    public int[][] merge2(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return new int[0][0];
        Stream<int[]> stream = Arrays.stream(intervals).sorted(Comparator.comparingInt(o -> o[0]));
        int[][] sorted = stream.toArray(int[][]::new);
        LinkedList<int[]> merged = new LinkedList<>();
        for (int[] ints : sorted) {
            if (merged.isEmpty() || merged.getLast()[1] < ints[0])
                merged.addLast(ints);
            else
                merged.getLast()[1] = Math.max(merged.getLast()[1], ints[1]);
        }
        return merged.toArray(new int[0][0]);
    }

}

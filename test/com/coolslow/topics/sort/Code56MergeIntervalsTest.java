package com.coolslow.topics.sort;

import com.coolslow.datastruct.utils.MyUtils;
import com.coolslow.leetcode.topics.sort.Code56MergeIntervals;
import org.junit.Test;

/**
 * by MrThanksgiving
 */
public class Code56MergeIntervalsTest {

    @Test
    public void testSolution() {
        Code56MergeIntervals solution = new Code56MergeIntervals();
        int[][] input = {{2, 6}, {8, 10}, {15, 18}, {1, 3}};
//        int[][] input = {{1, 4}, {0, 2}, {3, 5}};
        int[][] result = solution.merge(input);
        MyUtils.printArray(result);
    }
}

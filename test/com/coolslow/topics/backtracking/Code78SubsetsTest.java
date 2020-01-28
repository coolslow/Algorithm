package com.coolslow.topics.backtracking;

import com.coolslow.datastruct.utils.MyUtils;
import com.coolslow.leetcode.topics.backtracking.Code78Subsets;
import org.junit.Test;

import java.util.List;

/**
 * by MrThanksgiving
 */
public class Code78SubsetsTest {

    @Test
    public void testSolution() {
        Code78Subsets solution = new Code78Subsets();
        int[] input = {1, 2, 3};
        List<List<Integer>> result = solution.subsets(input);
        for (List<Integer> i : result) {
            MyUtils.printArray(i);
        }
    }
}

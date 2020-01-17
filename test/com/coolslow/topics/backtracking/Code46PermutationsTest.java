package com.coolslow.topics.backtracking;

import com.coolslow.datastruct.utils.MyUtils;
import com.coolslow.leetcode.topics.backtracking.Code46Permutations;
import org.junit.Test;

import java.util.List;

/**
 * by MrThanksgiving
 */
public class Code46PermutationsTest {

    @Test
    public void testSolution() {
        Code46Permutations solution = new Code46Permutations();
//        int[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        int[] input = {1, 2, 3, 4, 5, 6};
        List<List<Integer>> result = solution.permute(input);
        for (List<Integer> i : result) {
            MyUtils.printArray(i);
        }
        MyUtils.print("total="+result.size());

    }
}

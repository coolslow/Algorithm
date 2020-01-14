package com.coolslow.topics.array;

import com.coolslow.datastruct.utils.MyUtils;
import com.coolslow.leetcode.topics.array.Code334IncreasingTripletSubsequence;
import org.junit.Test;

/**
 * by MrThanksgiving
 */
public class Code334IncreasingTripletSubsequenceTest {

    @Test
    public void testSolution() {
        Code334IncreasingTripletSubsequence solution = new Code334IncreasingTripletSubsequence();

        int[][] input = {
                {1, 2, 1, 4, 2},
                {5, 1, 5, 5, 2, 5, 4},
                {1, 2, 1, 2, 1, 2, 1, 2, 1, 2},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 10, 1, 1, 1, 1, 10000}
        };
        for (int[] i : input) {
            boolean result = solution.increasingTriplet(i);
            MyUtils.println(MyUtils.ANSI_RED + result + MyUtils.ANSI_RESET);
        }

    }
}

package com.coolslow.topics.array;

import com.coolslow.datastruct.utils.MyUtils;
import com.coolslow.leetcode.topics.array.Code73SetMatrixZeroes;
import org.junit.Test;

/**
 * by MrThanksgiving
 */
public class Code73SetMatrixZeroesTest {

    @Test
    public void testSolution() {
        Code73SetMatrixZeroes solution = new Code73SetMatrixZeroes();
//        int[][] input = {
//                {1, 1, 1},
//                {1, 0, 1},
//                {1, 1, 1}
//        };
//        int[][] input = {
//                {0, 1, 2, 0},
//                {3, 4, 5, 2},
//                {1, 3, 1, 5}
//        };
        int[][] input = {
                {1, 1, 1},
                {0, 1, 2}
        };
        solution.setZeroes(input);
        MyUtils.printArray(input);
    }
}

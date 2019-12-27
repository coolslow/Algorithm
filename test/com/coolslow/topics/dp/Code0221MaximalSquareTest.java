package com.coolslow.topics.dp;

import com.coolslow.datastruct.utils.MyUtils;
import com.coolslow.leetcode.topics.dp.Code0221MaximalSquare;
import org.junit.Test;

/**
 * 最大正方形
 * by MrThanksgiving
 */
public class Code0221MaximalSquareTest {


    @Test
    public void testSolution() {
        Code0221MaximalSquare solution = new Code0221MaximalSquare();

//        char[][] matrix = {
//                {'0', '1'},
//        };
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '0'}
        };
        int result = solution.maximalSquare(matrix);
        MyUtils.print(MyUtils.ANSI_RED + result + MyUtils.ANSI_RESET);
    }

}

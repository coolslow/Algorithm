package com.coolslow.topics.dp;

import com.coolslow.datastruct.utils.MyUtils;
import com.coolslow.leetcode.topics.dp.Code221MaximalSquare;
import org.junit.Test;

/**
 * 最大正方形
 * by MrThanksgiving
 */
public class Code221MaximalSquareTest {


    @Test
    public void testSolution() {
        Code221MaximalSquare solution = new Code221MaximalSquare();

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

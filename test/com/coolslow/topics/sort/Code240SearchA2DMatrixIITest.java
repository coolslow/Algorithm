package com.coolslow.topics.sort;

import com.coolslow.datastruct.utils.MyUtils;
import com.coolslow.leetcode.topics.sort.Code240SearchA2DMatrixII;
import org.junit.Test;

/**
 * by MrThanksgiving
 */
public class Code240SearchA2DMatrixIITest {

    @Test
    public void testSolution() {
        Code240SearchA2DMatrixII solution = new Code240SearchA2DMatrixII();
//        int[][] input = {
//                {1, 4, 7, 11, 15},
//                {2, 5, 8, 12, 19},
//                {3, 6, 9, 16, 22},
//                {10, 13, 14, 17, 24},
//                {18, 21, 23, 26, 30}
//        };
        int[][] input = {{1}, {2}};
        int target = 2;
        boolean result = solution.searchMatrix(input, target);
        MyUtils.println(MyUtils.ANSI_RED + result + MyUtils.ANSI_RESET);
    }
}

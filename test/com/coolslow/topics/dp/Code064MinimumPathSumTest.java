package com.coolslow.topics.dp;


import com.coolslow.datastruct.utils.MyUtils;
import com.coolslow.leetcode.topics.dp.Code064MinimumPathSum;
import org.junit.Test;

/**
 * 最小路径和
 * by MrThanksgiving
 */
public class Code064MinimumPathSumTest {


    @Test
    public void testSolution() {
        Code064MinimumPathSum solution = new Code064MinimumPathSum();

//        [
//            [1,3,1],
//            [1,5,1],
//            [4,2,1]
//        ]

        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        int result = solution.minPathSum(grid);
        MyUtils.print(MyUtils.ANSI_RED + result + MyUtils.ANSI_RESET);
    }

}

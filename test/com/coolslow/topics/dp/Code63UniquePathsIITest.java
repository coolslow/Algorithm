package com.coolslow.topics.dp;


import com.coolslow.datastruct.utils.MyUtils;
import com.coolslow.leetcode.topics.dp.Code63UniquePathsII;
import org.junit.Test;

/**
 * 不同路径问题
 * by MrThanksgiving
 */
public class Code63UniquePathsIITest {

    @Test
    public void testSolution() {
        Code63UniquePathsII solution = new Code63UniquePathsII();
//           [
//             [0,0,0],
//             [0,1,0],
//             [0,0,0]
//           ]
        int[][] obstacleGrid = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        int result = solution.uniquePathsWithObstacles(obstacleGrid);
        MyUtils.print(MyUtils.ANSI_RED + result + MyUtils.ANSI_RESET);
    }

}

package com.coolslow.leetcode.topics.dp;


/**
 * 最小路径和
 * by MrThanksgiving
 */
public class Code64MinimumPathSum {


    /**
     * <pre>
     * 题目：
     *      给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
     *
     * 说明
     *      每次只能向下或者向右移动一步。
     *
     * 示例:
     *      输入:
     *      [
     *        [1,3,1],
     *        [1,5,1],
     *        [4,2,1]
     *      ]
     *      输出: 7
     *      解释: 因为路径 1→3→1→1→1 的总和最小。
     *
     * </pre>
     */
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int rs = grid.length;
        int cs = grid[0].length;
        int[][] dp = new int[rs][cs];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < rs; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < cs; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < rs; i++) {
            for (int j = 1; j < cs; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[rs - 1][cs - 1];
    }

}

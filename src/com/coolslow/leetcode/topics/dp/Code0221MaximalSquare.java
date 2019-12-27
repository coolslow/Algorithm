package com.coolslow.leetcode.topics.dp;

/**
 * 最大正方形
 * by MrThanksgiving
 */
public class Code221MaximalSquare {

    /**
     * <pre>
     * 题目：
     *      在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
     *
     * 示例:
     *      输入:
     *      1 0 1 0 0
     *      1 0 1 1 1
     *      1 1 1 1 1
     *      1 0 0 1 0
     *      输出: 4
     * </pre>
     */
    public int maximalSquare(char[][] matrix) {
        // dp[i][j] = 以右下角为点的最大正方形面积的边长。
        // dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        if (matrix.length == 1 && matrix[0].length == 1) {
            return matrix[0][0] == '1' ? 1 : 0;
        }
        int rs = matrix.length;
        int cs = matrix[0].length;
        int[][] dp = new int[rs][cs];
        int max = 0;
        for (int i = 0; i < rs; i++) {
            for (int j = 0; j < cs; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = matrix[i][j] == '1' ? 1 : 0;
                } else if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                }
                max = Math.max(dp[i][j], max);
            }
        }
        return max * max;
    }


}

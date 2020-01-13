package com.coolslow.leetcode.topics.array;

/**
 * 矩阵置零
 * by MrThanksgiving
 */
public class Code73SetMatrixZeroes {

    /**
     * <pre>
     * 题目：
     *      给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
     *
     * 示例 1:
     *      输入:
     *      [
     *        [1,1,1],
     *        [1,0,1],
     *        [1,1,1]
     *      ]
     *      输出:
     *      [
     *        [1,0,1],
     *        [0,0,0],
     *        [1,0,1]
     *      ]
     *
     * 示例 2:
     *      输入:
     *      [
     *        [0,1,2,0],
     *        [3,4,5,2],
     *        [1,3,1,5]
     *      ]
     *      输出:
     *      [
     *        [0,0,0,0],
     *        [0,4,5,0],
     *        [0,3,1,0]
     *      ]
     *
     * 进阶:
     *      一个直接的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
     *      一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
     *      你能想出一个常数空间的解决方案吗？
     *
     * </pre>
     */
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        int rc = matrix.length, cc = matrix[0].length;
        boolean flag = false;
        for (int i = 0; i < rc; i++) {
            if (matrix[i][0] == 0) flag = true;
            for (int j = 1; j < cc; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < rc; i++) {
            for (int j = 1; j < cc; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (matrix[0][0] == 0) {
            for (int i = 0; i < cc; i++) {
                matrix[0][i] = 0;
            }
        }
        if (flag) {
            for (int i = 0; i < rc; i++) {
                matrix[i][0] = 0;
            }
        }
    }
    // 空间复杂度O(1), 利用表头行与表头列。

    public void setZeroes2(int[][] matrix) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        int[] row = new int[matrix.length];
        int[] column = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = 1;
                    column[j] = 1;
                }
            }
        }
        for (int i = 0; i < row.length; i++) {
            if (row[i] == 1) {
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < column.length; i++) {
            if (column[i] == 1) {
                for (int j = 0; j < matrix.length; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
    }
    // O(n*m)  O(n+m)

    public void setZeroes3(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        int[][] mark = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    for (int k = 0; k < matrix[i].length; k++) { // row
                        mark[i][k] = 1;
                    }
                    for (int k = 0; k < matrix.length; k++) { // column
                        mark[k][j] = 1;
                    }
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (mark[i][j] == 1)
                    matrix[i][j] = 0;
            }
        }
    }
    // O(n*m)  O(n^2)

}

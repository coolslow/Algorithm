package com.coolslow.leetcode.top1000plus;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. 螺旋矩阵
 * 题目：给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 *
 * 示例1：
 *     输入:
 *      [
 *          [ 1, 2, 3 ],
 *          [ 4, 5, 6 ],
 *          [ 7, 8, 9 ]
 *      ]
 *      输出：[1, 2, 3, 6, 9, 8, 7, 4, 5]
 *
 * 示例2：
 *      输入：
 *      [
 *          [ 1, 2, 3, 4 ],
 *          [ 5, 6, 7, 8 ],
 *          [ 9, 10, 11, 12 ]
 *      ]
 *      输出：[1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]
 */
public class NO54_SpiralMatrix {

    /**
     * 方法二：按层模拟
     * 思路：最外层所有元素按照顺时针顺序输出，其次是次外层，以此类推。
     */
    public static List<Integer> spiralMatrix(int[][] matrix) {
        // 声明一个作为输出的ArrayList
        List ans = new ArrayList();

        if(matrix.length == 0) {
            return ans;
        }

        // 设置行的起始和结束的初始下标
        int r1 = 0, r2 = matrix.length - 1;
        // 设置列的起始和结束的初始下标
        int c1 = 0, c2 = matrix[0].length - 1;

        while(r1 <= r2 && c1 <= c2) {
            for(int c = c1; c <= c2; c++) {
                // 行不变，列变
                ans.add(matrix[r1][c]);
            }

            for(int r = r1 + 1; r <= r2; r++) {
                // 列不变，行变
                ans.add(matrix[r][c2]);
            }

            if(r1 < r2 && c1 < c2) {
                for(int c = c2 - 1; c > c1; c--) {
                    ans.add(matrix[r2][c]);
                }

                for(int r = r2; r > r1; r--) {
                    ans.add(matrix[r][c1]);
                }
            }
            r1++;
            r2--;
            c1++;
            c2--;
        }

        return ans;
    }

}

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
     *
     * 对于每层，可以从左上方开始以顺时针顺序遍历所有元素，假设当前层左上角坐标为(r1, c1)，右下角坐标是(r2, c2)。
     * 首先，遍历上方的所有元素 (r1, c)，按照c = c1,...,c2 的顺序。
     * 然后，遍历右侧的所有元素 (r, c2)，按照r = r1 + 1,...,r2 的顺序。
     * 如果这一层有四条边（也就是 r1 < r2 &&c1 < c2 ）
     * [ [ 1, 1, 1, 1, 1, 1 ],  top: c from c1 ... c2
     *   [ 1, 2, 2, 2, 2, 1 ],  right: r from r1 + 1 ... r2
     *   [ 1, 2, 3, 3, 2, 1 ],  bottom: c from c2 + 1 ... c1
     *   [ 1, 2, 2, 2, 2, 1 ],  left: r from r2 + 1 ... r1
     *   [ 1, 1, 1, 1, 1, 1 ] ]
     *
     *
     * 复杂度分析：
     *  - 时间复杂度： O(N)，其中 N 是输入矩阵所有元素的个数。因为我们将矩阵中的每个元素都添加进答案里。
     *  - 空间复杂度： O(N)，需要矩阵 ans 存储信息。
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

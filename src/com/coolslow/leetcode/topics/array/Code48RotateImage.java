package com.coolslow.leetcode.topics.array;

/**
 * 旋转图像
 * by MrThanksgiving
 */
public class Code48RotateImage {

    /**
     * <pre>
     * 题目：
     *      给定一个 n × n 的二维矩阵表示一个图像。
     *      将图像顺时针旋转 90 度。
     *
     *      说明：
     *      你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
     *
     * 示例 1:
     *      给定 matrix =
     *      [
     *        [1,2,3],
     *        [4,5,6],
     *        [7,8,9]
     *      ],
     *
     *      原地旋转输入矩阵，使其变为:
     *      [
     *        [7,4,1],
     *        [8,5,2],
     *        [9,6,3]
     *      ]
     *
     * 示例 2:
     *      给定 matrix =
     *      [
     *        [ 5, 1, 9,11],
     *        [ 2, 4, 8,10],
     *        [13, 3, 6, 7],
     *        [15,14,12,16]
     *      ],
     *
     *      原地旋转输入矩阵，使其变为:
     *      [
     *        [15,13, 2, 5],
     *        [14, 3, 4, 1],
     *        [12, 6, 8, 9],
     *        [16, 7,10,11]
     *      ]
     *
     * </pre>
     */
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return;
        int count = matrix.length;
        int temp, rowIndex, columnIndex;
        for (int i = 0; i < count / 2; i++) {
            for (int j = i; j < count - 1 - i; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[count - 1 - j][i];
                matrix[count - 1 - j][i] = matrix[count - 1 - i][count - 1 - j];
                matrix[count - 1 - i][count - 1 - j] = matrix[j][count - 1 - i];
                matrix[j][count - 1 - i] = temp;
            }
        }
    }

}

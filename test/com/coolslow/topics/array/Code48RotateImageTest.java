package com.coolslow.topics.array;

import com.coolslow.datastruct.utils.MyUtils;
import com.coolslow.leetcode.topics.array.Code48RotateImage;
import org.junit.Test;

/**
 * by MrThanksgiving
 */
public class Code48RotateImageTest {

    @Test
    public void testSolution() {
        Code48RotateImage solution = new Code48RotateImage();
        int n = 5;
        int[][] matrix = new int[n][n];
        int k = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = k++;
            }
        }
        MyUtils.printArray(matrix);
        solution.rotate(matrix);
        MyUtils.printArray(matrix);
    }
}

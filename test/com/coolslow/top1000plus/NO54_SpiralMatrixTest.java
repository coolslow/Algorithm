package com.coolslow.top1000plus;

import com.coolslow.leetcode.top1000plus.NO54_SpiralMatrix;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NO54_SpiralMatrixTest {

    @Test
    public void spiralMatrixShouldCorrect() {
        int[][] testMatrix1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        List<Integer> matrixResult1 = Arrays.asList(1, 2, 3, 6, 9, 8, 7, 4, 5);
        Assert.assertEquals(matrixResult1, NO54_SpiralMatrix.spiralMatrix(testMatrix1));
    }
}

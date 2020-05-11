package com.coolslow.top1000plus;

import com.coolslow.leetcode.top1000plus.NO42_TrappingRainWater;
import org.junit.Assert;
import org.junit.Test;

public class NO42_TrappingRainWaterTest {

    @Test
    public void shouldTrappingRainWaterCorrectly() {

        int[] test = new int[] {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[] test1 = new int[] {1, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int result = NO42_TrappingRainWater.trapRainWaterByRow(test);
        int result1 = NO42_TrappingRainWater.trapRainWaterByRow(test1);
        Assert.assertEquals(6, result);
        Assert.assertEquals(6, result1);
    }
}

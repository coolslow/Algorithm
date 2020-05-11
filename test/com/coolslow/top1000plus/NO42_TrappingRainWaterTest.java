package com.coolslow.top1000plus;

import com.coolslow.leetcode.top1000plus.NO42_TrappingRainWater;
import org.junit.Assert;
import org.junit.Test;

public class NO42_TrappingRainWaterTest {

    @Test
    public void shouldTrappingRainWaterCorrectly() {

        int[] test = new int[] {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[] test1 = new int[] {1, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

        int[] test2 = new int[] {1, 1, 1};
        int[] test3 = new int[] {2, 3, 4, 1};

        int result = NO42_TrappingRainWater.trapRainWaterByRow(test);
        int result1 = NO42_TrappingRainWater.trapRainWaterByRow(test1);

        int result2 = NO42_TrappingRainWater.trapWithDp(test);
        int result3 = NO42_TrappingRainWater.trapWithDp(test1);

        int result4 = NO42_TrappingRainWater.trapWithDp(test2);
        int result5 = NO42_TrappingRainWater.trapWithDp(test3);

        Assert.assertEquals(6, result);
        Assert.assertEquals(6, result1);

        Assert.assertEquals(6, result2);
        Assert.assertEquals(6, result3);

        Assert.assertEquals(0, result4);
        Assert.assertEquals(0, result5);
    }
}

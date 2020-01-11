package com.coolslow.top100plus;

import com.coolslow.leetcode.top100plus.NO53_TheMaxSubArray;
import org.junit.Assert;
import org.junit.Test;

public class NO53_TheMaxSubArrayTest {
    @Test
    public void shouldGiveTheMaxSumOfSubArray() {
        int[] arr = new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        int result = NO53_TheMaxSubArray.maxSubArray(arr);

        int result1 = NO53_TheMaxSubArray.maxSubArraryShorter(arr);

        Assert.assertEquals(6, result);
        Assert.assertEquals(6, result1);
    }
}

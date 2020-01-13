package com.coolslow.top100plus;

import com.coolslow.leetcode.top100plus.NO53_TheMaxSubArray;
import org.junit.Assert;
import org.junit.Test;

public class NO53_TheMaxSubArrayTest {
    @Test
    public void shouldGiveTheMaxSumOfSubArray() {
        int[] arr = new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        int[] arr1 = new int[] { 1 };
        int[] arr2 = new int[] { 1, 2, 3, 4, 5, -4, -3, -2, -1};

        int result = NO53_TheMaxSubArray.maxSubArray(arr);
        int result1 = NO53_TheMaxSubArray.maxSubArrayShorter(arr);

        int result2 = NO53_TheMaxSubArray.maxSubArray(arr1);
        int result3 = NO53_TheMaxSubArray.maxSubArrayShorter(arr1);

        int result4 = NO53_TheMaxSubArray.maxSubArray(arr2);
        int result5 = NO53_TheMaxSubArray.maxSubArrayShorter(arr2);

        Assert.assertEquals(6, result);
        Assert.assertEquals(6, result1);

        Assert.assertEquals(1, result2);
        Assert.assertEquals(1, result3);

        Assert.assertEquals(15, result4);
        Assert.assertEquals(15, result5);
    }
}

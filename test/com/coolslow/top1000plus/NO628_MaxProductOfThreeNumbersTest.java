package com.coolslow.top1000plus;

import com.coolslow.leetcode.top1000plus.NO628_MaxProductOfThreeNumbers;
import org.junit.Assert;
import org.junit.Test;

public class NO628_MaxProductOfThreeNumbersTest {

    @Test
    public void maxProductOfThreeNumbers() {

        int[] arr = new int[] {0, 1, 2, 2, 8, -8};
        int[] arr1 = new int[] {-1, -2, -100, 0};
        int[] arr2 = new int[] {-1, -2, -100, 9};

        int result = NO628_MaxProductOfThreeNumbers.maximumProduct(arr);
        int result1 = NO628_MaxProductOfThreeNumbers.maximumProduct(arr1);
        int result2 = NO628_MaxProductOfThreeNumbers.maximumProduct(arr2);

        Assert.assertEquals(32, result);
        Assert.assertEquals(0, result1);
        Assert.assertEquals(1800, result2);
    }
}

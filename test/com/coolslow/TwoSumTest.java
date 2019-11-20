package com.coolslow;

import com.coolslow.leetcode.top100.TwoSum;
import org.junit.Assert;
import org.junit.Test;

public class TwoSumTest {
    @Test
    public void shouldGetCorrectArrayForTwoSum() {
        int[] nums = new int[] {2, 7, 11, 15};
        int target = 9;

        // 暴力方法，时间复杂度O(n^2)
        int[] result = TwoSum.twoSum(nums, target);
        // 利用HashMap，空间换时间，时间复杂度O(n)，空间复杂度O(n)
        int[] result1 = TwoSum.twoSumWithHashMap(nums, target);
        Assert.assertArrayEquals(new int[] {0, 1,}, result);
        Assert.assertArrayEquals(new int[] {0, 1,}, result1);
    }
}

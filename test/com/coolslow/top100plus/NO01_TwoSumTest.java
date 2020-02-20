package com.coolslow.top100plus;

import com.coolslow.leetcode.top100plus.NO01_TwoSum;
import com.coolslow.leetcode.top100plus.NO198_HouseRobber;
import com.coolslow.leetcode.top100plus.playground.TwoSumPlayground;
import org.junit.Assert;
import org.junit.Test;

public class NO01_TwoSumTest {
    @Test
    public void shouldGetCorrectArrayForTwoSum() {
        int[] nums = new int[] {2, 7, 11, 15};
        int target = 9;

        // 暴力方法，时间复杂度O(n^2)
        int[] result = NO01_TwoSum.twoSum(nums, target);
        // 利用HashMap，空间换时间，时间复杂度O(n)，空间复杂度O(n)
        int[] result1 = NO01_TwoSum.twoSumWithHashMap(nums, target);
        int[] result2 = NO01_TwoSum.twoSumWithOnePassHashMap(nums, target);

        Assert.assertArrayEquals(new int[] {0, 1}, result);
        Assert.assertArrayEquals(new int[] {0, 1}, result1);
        Assert.assertArrayEquals(new int[] {0, 1}, result2);
    }

    @Test
    public void shouldFindCorrectIndexForTwoSum() {
        int[] nums = new int[] {2, 8, 11, 15};
        int target = 9;

        int[] nums1 = new int[] {0, 1, 3, 8, 7, 11, 12, 13};
        int target1 = 4;

        int[] result = TwoSumPlayground.twoSum(nums, target);
        Assert.assertArrayEquals(new int[] {}, result);

        int[] result1 = TwoSumPlayground.twoSumWithHashMap(nums1, target1);
        Assert.assertArrayEquals(new int[] {1, 2}, result1);
    }
}

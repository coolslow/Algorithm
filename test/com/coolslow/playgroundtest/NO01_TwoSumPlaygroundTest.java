package com.coolslow.playgroundtest;

import com.coolslow.leetcode.top1000plus.playground.NO01_TwoSumPlayground;
import org.junit.Assert;
import org.junit.Test;

public class NO01_TwoSumPlaygroundTest {

    @Test
    public void testTwoSumInPlayground() {
        int[] nums = new int[] {2, 7, 11, 15};
        int target = 9;

        int[] nums1 = new int[] {2, 5, 5, 15};
        int target1 = 10;

        int[] result = NO01_TwoSumPlayground.twoSumInPlayground(nums, target);
        Assert.assertArrayEquals(new int[] {0, 1}, result);

        int[] result1 = NO01_TwoSumPlayground.twoSumInPlayground(nums1, target1);
        Assert.assertArrayEquals(new int[] {1, 2}, result1);
    }
}

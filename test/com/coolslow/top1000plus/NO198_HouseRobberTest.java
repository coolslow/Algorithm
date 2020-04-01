package com.coolslow.top1000plus;

import com.coolslow.leetcode.top1000plus.NO198_HouseRobber;
import org.junit.Assert;
import org.junit.Test;

public class NO198_HouseRobberTest {

    @Test
    public void HouseRobberShouldGetMaxValue() {
        int[] nums = new int[] {2, 7, 9, 3, 1};
        int[] nums1 = new int[] {9, 1, 1, 2, 3};

        int result1 = NO198_HouseRobber.rob(nums);
        int result2 = NO198_HouseRobber.rob(nums1);

        Assert.assertEquals(12, result1);
        Assert.assertEquals(13, result2);
    }
}

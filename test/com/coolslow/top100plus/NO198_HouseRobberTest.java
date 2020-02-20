package com.coolslow.top100plus;

import com.coolslow.leetcode.top100plus.NO198_HouseRobber;
import org.junit.Assert;
import org.junit.Test;

public class NO198_HouseRobberTest {

    @Test
    public void HouseRobberShouldGetMaxValue() {
        int[] nums = new int[] {2, 7, 9, 3, 1};
        int result1 = NO198_HouseRobber.rob(nums);
        Assert.assertEquals(12, result1);
    }
}

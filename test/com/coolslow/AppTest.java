package com.coolslow;

import com.coolslow.leetcode.top100.TwoSum;
import org.junit.Assert;
import org.junit.Test;

public class AppTest {

    @Test
    public void shouldAnswerCorrectArrayForTwoSum() {
        int[] nums = new int[] {2, 7, 11, 15};
        int target = 9;

        int[] result = TwoSum.twoSum(nums, target);
        Assert.assertArrayEquals(new int[] {0, 1,}, result);
    }
}

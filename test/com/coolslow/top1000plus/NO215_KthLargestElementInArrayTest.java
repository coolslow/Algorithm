package com.coolslow.top1000plus;

import com.coolslow.leetcode.top1000plus.NO215_KthLargestElementInArray;
import org.junit.Assert;
import org.junit.Test;

public class NO215_KthLargestElementInArrayTest {

    @Test
    public void shouldReturnKthLargestNum() {

        int[] nums = new int[] {3, 2, 1, 5, 6, 4};
        int result = NO215_KthLargestElementInArray.findKthLargest(nums, 3);

        Assert.assertEquals(4, result);
    }
}

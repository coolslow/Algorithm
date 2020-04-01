package com.coolslow.top1000plus;

import com.coolslow.leetcode.top1000plus.NO26_RemoveDuplicateFromSortedArray;
import org.junit.Assert;
import org.junit.Test;

public class NO26_RemoveDuplicateFromSortedArrayTest {
    @Test
    public void shouldRemoveDuplicateFromSortedArray() {
        // 验证空数组的返回结果
        int [] emptyArr = new int[] {};
        // 验证非空有序数组的返回结果
        int[] nums = new int[] {0, 0, 1, 1, 1, 2, 3, 3, 4, 5, 5};
        // 验证无重复数组的返回结果
        int[] noDuplicates = new int[] { 1, 2, 3, 5 };

        int result = NO26_RemoveDuplicateFromSortedArray.removeDuplicates(nums);
        int result1 = NO26_RemoveDuplicateFromSortedArray.removeDuplicates(emptyArr);
        int result2 = NO26_RemoveDuplicateFromSortedArray.removeDuplicates(noDuplicates);
        Assert.assertEquals(6, result);
        Assert.assertEquals(0, result1);
        Assert.assertEquals(4, result2);
    }
}

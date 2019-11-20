package com.coolslow;

import com.coolslow.leetcode.top100.RemoveDuplcateFromSortedArray;
import org.junit.Assert;
import org.junit.Test;

public class RemoveDuplicateFromSortedArrayTest {
    @Test
    public void shouldRemoveDuplicateFromSourtedArray() {
        int [] emptyArr = new int[] {};
        int[] nums = new int[] {0, 0, 1, 1, 1, 2, 3, 3, 4, 5, 5};

        int result = RemoveDuplcateFromSortedArray.removeDuplicates(nums);
        int result1 = RemoveDuplcateFromSortedArray.removeDuplicates(emptyArr);
        Assert.assertEquals(6, result);
        Assert.assertEquals(0, result1);
    }
}

package com.coolslow.top1000plus;

import com.coolslow.leetcode.top1000plus.NO80_RemoveDuplicateFromSortedArrayII;
import org.junit.Assert;
import org.junit.Test;

public class NO80_RemoveDuplicatesTest {

    @Test
    public void shouldRemoveDuplicatesCorrectly() {
        int[] arr = new int[] { 1, 2, 2, 3, 3, 3, 5, 8 ,8};
        int result = NO80_RemoveDuplicateFromSortedArrayII.removeDuplicates(arr);

        int[] arr1 = new int[] {1, 2, 3, 4, 4};
        int result1 = NO80_RemoveDuplicateFromSortedArrayII.removeDuplicates(arr1);

        Assert.assertEquals(8, result);
        Assert.assertEquals(5, result1);
    }
}

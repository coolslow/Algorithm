package com.coolslow.sort;

import com.coolslow.leetcode.interview.topics.sort.QuickSort;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class QuickSortTest {

    @Test
    public void checkQuickSortTest() {
        int[] nums = new int[] {5, 7, 1, 8, 4};
        QuickSort.quickSort(nums, 0, nums.length - 1);

        for (int num : nums) {
            System.out.println(num);
        }
        int[] expected = new int[] {1, 4, 5, 7, 8};
        Assert.assertArrayEquals(expected, nums);
    }
}

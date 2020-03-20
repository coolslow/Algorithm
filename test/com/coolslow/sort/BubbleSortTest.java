package com.coolslow.sort;

import com.coolslow.leetcode.sort.BubbleSort;
import org.junit.Assert;
import org.junit.Test;

public class BubbleSortTest {

    @Test
    public void checkBubbleSort() {
        int[] arr = new int[] {2, 1, 3, 5, 7, 9, 0, 11};
        int[] expected = new int[] {0, 1, 2, 3, 5, 7, 9, 11};
        int[] result = BubbleSort.bubbleSort(arr);

        Assert.assertArrayEquals(expected, result);
    }
}

package com.coolslow.top1000plus;

import org.junit.Assert;
import org.junit.Test;
import com.coolslow.leetcode.top1000plus.NO35_SearchInsertPosition;

/**
 * Title: NO35_SearchInsertPositionTest
 * Desc: todo
 * Date: 2020/9/1 11:55 上午
 * Author: ming
 */
public class NO35_SearchInsertPositionTest {

    @Test
    public void checkSearchInsertPosition() {

        int[] arr = new int[] { 1, 3, 5, 6 };
        int data1 = 5;
        int data2 = 2;
        int data3 = 7;

        int res1 = NO35_SearchInsertPosition.searchInsertPosition(arr, data1);
        int res2 = NO35_SearchInsertPosition.searchInsertPosition(arr, data2);
        int res3 = NO35_SearchInsertPosition.searchInsertPosition(arr, data3);

        Assert.assertEquals(2, res1);
        Assert.assertEquals(1, res2);
        Assert.assertEquals(4, res3);
    }
}

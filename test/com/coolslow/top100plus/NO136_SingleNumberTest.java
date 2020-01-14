package com.coolslow.top100plus;

import com.coolslow.leetcode.top100plus.NO136_SingleNumber;
import org.junit.Assert;
import org.junit.Test;

public class NO136_SingleNumberTest {

    @Test
    public void shouldFindTheSingleNumberCorrectly() {

        int[] arr1 = new int[] { 2, 3, 2, 1, 1};
        int[] arr2 = new int[] { 2 };
        int result1 = NO136_SingleNumber.singleNumber(arr1);
        int result2 = NO136_SingleNumber.singleNumber(arr2);

        Assert.assertEquals(3, result1);
        Assert.assertEquals(2, result2);
    }
}

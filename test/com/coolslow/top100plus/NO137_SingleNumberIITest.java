package com.coolslow.top100plus;

import com.coolslow.leetcode.top1000plus.NO137_SingleNumberII;
import org.junit.Assert;
import org.junit.Test;

public class NO137_SingleNumberIITest {

    @Test
    public void shouldSingleNumberIIGetCorrectNum() {

        int[] arr = new int[] { 0, 1, 0, 1, 0, 1, 9};
        int result = NO137_SingleNumberII.singleNumberII(arr);
        Assert.assertEquals(9, result);
    }
}

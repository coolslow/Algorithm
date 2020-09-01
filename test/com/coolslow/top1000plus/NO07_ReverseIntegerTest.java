package com.coolslow.top1000plus;

import com.coolslow.leetcode.top1000plus.playground.NO07_ReverseIntegerPlayground;
import org.junit.Assert;
import org.junit.Test;

public class NO07_ReverseIntegerTest {
    @Test
    public void shouldCorrectReverseInteger() {
        int x1 = 120;
        int x2 = 0;
        int x3 = -120;
        int x4 = 2147483647;
        int x5 = -2147483648;

        System.out.println(x4/10);

        int result1 = NO07_ReverseIntegerPlayground.reverse(x1);
        int result2 = NO07_ReverseIntegerPlayground.reverse(x2);
        int result3 = NO07_ReverseIntegerPlayground.reverse(x3);
        int result4 = NO07_ReverseIntegerPlayground.reverse(x4);
        int result5 = NO07_ReverseIntegerPlayground.reverse(x5);

        Assert.assertEquals(21, result1);
        Assert.assertEquals(0, result2);
        Assert.assertEquals(-21, result3);
        Assert.assertEquals(0, result4);
        Assert.assertEquals(0, result5);
    }
}

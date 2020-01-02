package com.coolslow;

import com.coolslow.leetcode.top100.playground.ReverseIntegerPlayground;
import org.junit.Assert;
import org.junit.Test;

public class NO07ReverseIntegerTest {
    @Test
    public void shouldCorrectReverseInteger() {
        int x1 = 120;
        int x2 = 0;
        int x3 = -120;
        int x4 = 2147483647;
        int x5 = -2147483648;

        System.out.println(x4/10);

        int result1 = ReverseIntegerPlayground.reverse(x1);
        int result2 = ReverseIntegerPlayground.reverse(x2);
        int result3 = ReverseIntegerPlayground.reverse(x3);
        int result4 = ReverseIntegerPlayground.reverse(x4);
        int result5 = ReverseIntegerPlayground.reverse(x5);

        Assert.assertEquals(21, result1);
        Assert.assertEquals(0, result2);
        Assert.assertEquals(-21, result3);
        Assert.assertEquals(0, result4);
        Assert.assertEquals(0, result5);
    }
}

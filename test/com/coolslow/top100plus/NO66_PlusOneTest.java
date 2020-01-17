package com.coolslow.top100plus;

import com.coolslow.leetcode.top100plus.NO66_PlusOne;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class NO66_PlusOneTest {

    @Test
    public void plusOneShouledCorrect(){

        int[] result1 = NO66_PlusOne.plusOne1(new int[] { 1, 2, 9 });
        int[] result2 = NO66_PlusOne.plusOne2(new int[] { 1, 2, 9 });

        int[] result3 = NO66_PlusOne.plusOne2(new int[] { 9, 2, 9 });
        int[] result4 = NO66_PlusOne.plusOne2(new int[] { 9, 2, 9 });

        int[] result5 = NO66_PlusOne.plusOne2(new int[] { 9, 9, 9 });
        int[] result6 = NO66_PlusOne.plusOne2(new int[] { 9, 9, 9 });

        Assert.assertArrayEquals(new int[] { 1, 3, 0 }, result1);
        Assert.assertArrayEquals(new int[] { 1, 3, 0 }, result2);

        Assert.assertArrayEquals(new int[] { 9, 3, 0 }, result3);
        Assert.assertArrayEquals(new int[] { 9, 3, 0 }, result4);

        Assert.assertArrayEquals(new int[] { 1, 0, 0, 0 }, result5);
        Assert.assertArrayEquals(new int[] { 1, 0, 0, 0 }, result6);
    }
}

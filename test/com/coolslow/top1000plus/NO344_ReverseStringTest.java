package com.coolslow.top1000plus;

import com.coolslow.leetcode.top1000plus.NO344_ReverseString;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class NO344_ReverseStringTest {

    @Test
    public void reverseStringShouldCorrect() {
        char[] test = {'h', 'e', 'l', 'l', 'o'};
        NO344_ReverseString.reverseString(test);
        System.out.println(test);

        char[] result = {'o', 'l', 'l', 'e', 'h'};
        Assert.assertEquals(Arrays.toString(result), Arrays.toString(test));
    }
}

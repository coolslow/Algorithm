package com.coolslow.top1000plus;

import com.coolslow.leetcode.top1000plus.playground.NO03_LongestSubstringPlayground;
import org.junit.Assert;
import org.junit.Test;

public class NO03_LongestSubstringTest {

    @Test
    public void shouldReturnCorrectLongestSubstringNum() {
        String s = "abcabc"; // 最长子串 abc
        String s1 = "abcdeefghi"; // 最长子串 efghijklmn
        String s3 = "wcnmbb";

        int result = NO03_LongestSubstringPlayground.lengthOfLongestSubString(s);
        int result1 = NO03_LongestSubstringPlayground.lengthOfLongestSubstringWithSlidingWindow(s);
        int result2 = NO03_LongestSubstringPlayground.lengthOfLongestSubstringWithSlidingWindow(s1);
        int result3 = NO03_LongestSubstringPlayground.lengthOfLongestSubstringWithOptimizedSlidingWindow(s3);
        Assert.assertEquals(3, result);
        Assert.assertEquals(3, result1);
        Assert.assertEquals(5, result2);
        Assert.assertEquals(5, result3);
    }
}

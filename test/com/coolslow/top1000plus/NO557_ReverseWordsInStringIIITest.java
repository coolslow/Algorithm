package com.coolslow.top1000plus;

import com.coolslow.leetcode.top1000plus.NO557_ReverseWordsInStringIII;
import org.junit.Assert;
import org.junit.Test;

public class NO557_ReverseWordsInStringIIITest {

    @Test
    public void wordsShouldREversedCorrectly() {
        String test = "Hello World!";

        String result = NO557_ReverseWordsInStringIII.reverseWords(test);
        String result1 = NO557_ReverseWordsInStringIII.reverseWordsII(test);

        Assert.assertEquals("olleH !dlroW", result);
        Assert.assertEquals("olleH !dlroW", result1);
    }
}

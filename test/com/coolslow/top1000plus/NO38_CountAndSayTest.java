package com.coolslow.top1000plus;

import com.coolslow.leetcode.top1000plus.NO38_CountAndSay;
import org.junit.Assert;
import org.junit.Test;

public class NO38_CountAndSayTest {

    @Test
    public void shouldCountAndSayCorrectly() {
        String str1 = NO38_CountAndSay.countAndSay(1);
        String str2 = NO38_CountAndSay.countAndSay(2);
        String str3 = NO38_CountAndSay.countAndSay(3);
        String str4 = NO38_CountAndSay.countAndSay(4);
        Assert.assertEquals("1", str1);
        Assert.assertEquals("11", str2);
        Assert.assertEquals("21", str3);
        Assert.assertEquals("1211", str4);
    }
}

package com.coolslow.top1000plus;

import com.coolslow.leetcode.top1000plus.NO443_StringCompression;
import org.junit.Assert;
import org.junit.Test;

public class NO443_StringCompressionTest {
    @Test
    public void stringCompressTest() {

        char[] chars = new char[] {'a', 'a', 'a', 'b', 'b', 'c', 'd', 'd'};
        int result = NO443_StringCompression.compress(chars);
        // "a3b2cd4"
//        Assert.assertEquals(7, result);

        String res = NO443_StringCompression.compressString("aaabbcdd");
        System.out.println(res);
    }
}

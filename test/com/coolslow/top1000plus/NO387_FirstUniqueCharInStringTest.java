package com.coolslow.top1000plus;

import com.coolslow.leetcode.top1000plus.NO387_FirstUniqueCharInString;
import org.junit.Assert;
import org.junit.Test;

public class NO387_FirstUniqueCharInStringTest {

    @Test
    public void shouldGetFirstUniqueChar() {
        String s1 = "leetcode";
        String s2 = "loveleetcode";

        int result1 = NO387_FirstUniqueCharInString.firstQuiqueCharInString(s1);
        int result2 = NO387_FirstUniqueCharInString.firstQuiqueCharInString(s2);

        Assert.assertEquals(0, result1);
        Assert.assertEquals(2, result2);
    }
}

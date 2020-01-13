package com.coolslow.top100plus;

import com.coolslow.leetcode.top100plus.NO14_LongestCommonPrefix;
import org.junit.Assert;
import org.junit.Test;

public class NO14_LongestCommonPrefixTest {

    @Test
    public void shouldGetLongestCommonPrefix() {

        String[] strs = new String[] { "", "", "", "" };
        String[] strs0 = new String[] { };
        String[] strs1 = new String[] { "fly", "flee", "flow"};
        String result = NO14_LongestCommonPrefix.getTheLongestCommonPrefix(strs);
        String result0 = NO14_LongestCommonPrefix.getTheLongestCommonPrefix(strs0);
        String result1 = NO14_LongestCommonPrefix.getTheLongestCommonPrefix(strs1);

        Assert.assertEquals("", result);
        Assert.assertEquals("", result0);
        Assert.assertEquals("fl", result1);
    }
}

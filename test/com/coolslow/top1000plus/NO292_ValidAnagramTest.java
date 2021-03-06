package com.coolslow.top1000plus;

import com.coolslow.leetcode.top1000plus.NO292_ValidAnagram;
import org.junit.Assert;
import org.junit.Test;

public class NO292_ValidAnagramTest {
    @Test
    public void shouldFindValidAnagram() {
        boolean isValidAnagram = NO292_ValidAnagram.isAnagram("dog", "god");
        Assert.assertTrue(isValidAnagram);

        boolean isValidAnagram1 = NO292_ValidAnagram.isAnagram("food", "foot");
        Assert.assertFalse(isValidAnagram1);
    }
}

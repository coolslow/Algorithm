package com.coolslow.topics.string;

import com.coolslow.datastruct.utils.MyUtils;
import com.coolslow.leetcode.topics.string.Code242ValidAnagram;
import org.junit.Test;

/**
 * by MrThanksgiving
 */
public class Code242ValidAnagramTest {

    @Test
    public void testSolution() {
        Code242ValidAnagram solution = new Code242ValidAnagram();
        String s1 = "anagram";
        String s2 = "nagaram";
        boolean result = solution.isAnagram(s1, s2);
        MyUtils.println(MyUtils.ANSI_RED + result + MyUtils.ANSI_RESET);
    }
}

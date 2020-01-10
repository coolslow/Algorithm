package com.coolslow.topics.string;

import com.coolslow.datastruct.utils.MyUtils;
import com.coolslow.leetcode.topics.string.Code28ImplementStrStr;
import org.junit.Test;

/**
 * by MrThanksgiving
 */
public class Code28ImplementStrStrTest {

    @Test
    public void testSolution() {
        Code28ImplementStrStr solution = new Code28ImplementStrStr();
        int[] nums = {};
        String haystack = "hello";
        String needle = "ll";
//        String haystack = "aaaaabbc";
//        String needle = "bbc";
        int result = solution.strStr(haystack, needle);
        MyUtils.println(MyUtils.ANSI_RED + result + MyUtils.ANSI_RESET);
    }
}

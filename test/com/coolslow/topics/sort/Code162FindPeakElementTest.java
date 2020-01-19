package com.coolslow.topics.sort;

import com.coolslow.datastruct.utils.MyUtils;
import com.coolslow.leetcode.topics.sort.Code162FindPeakElement;
import org.junit.Test;

/**
 * by MrThanksgiving
 */
public class Code162FindPeakElementTest {

    @Test
    public void testSolution() {
        Code162FindPeakElement solution = new Code162FindPeakElement();
        int[] input = {1, 2, 3, 1};
        int result = solution.findPeakElement(input);
        MyUtils.println(MyUtils.ANSI_RED + result + MyUtils.ANSI_RESET);
    }
}

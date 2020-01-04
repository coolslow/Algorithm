package com.coolslow.topics.string;

import com.coolslow.datastruct.utils.MyUtils;
import com.coolslow.leetcode.topics.string.Code344ReverseString;
import org.junit.Test;

/**
 * by MrThanksgiving
 */
public class Code344ReverseStringTest {


    @Test
    public void testSolution() {
        Code344ReverseString solution = new Code344ReverseString();
//        char[] nums = {'h', 'e', 'l', 'l', 'o'};
        char[] nums = {'H', 'a', 'n', 'n', 'a', 'h'};
        solution.reverseString(nums);
        MyUtils.printArray(nums);
    }
}

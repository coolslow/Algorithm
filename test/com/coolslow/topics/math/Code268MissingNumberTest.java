package com.coolslow.topics.math;

import com.coolslow.datastruct.utils.MyUtils;
import com.coolslow.leetcode.topics.math.Code268MissingNumber;
import org.junit.Test;

/**
 * by MrThanksgiving
 */
public class Code268MissingNumberTest {

    @Test
    public void testSolution() {
        Code268MissingNumber solution = new Code268MissingNumber();
//        int[] input = {3, 0, 2};
        int[] input = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        int result = solution.missingNumber(input);
        MyUtils.println(MyUtils.ANSI_RED + result + MyUtils.ANSI_RESET);
    }
}

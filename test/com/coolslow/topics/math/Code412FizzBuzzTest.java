package com.coolslow.topics.math;

import com.coolslow.datastruct.utils.MyUtils;
import com.coolslow.leetcode.topics.math.Code412FizzBuzz;
import org.junit.Test;

import java.util.List;

/**
 * by MrThanksgiving
 */
public class Code412FizzBuzzTest {

    @Test
    public void testSolution() {
        Code412FizzBuzz solution = new Code412FizzBuzz();
        int n = 15;
        List<String> result = solution.fizzBuzz(n);
        MyUtils.printArray(result);
    }
}

package com.coolslow.topics.design;

import com.coolslow.datastruct.utils.MyUtils;
import com.coolslow.leetcode.topics.design.Code155MinStack;
import org.junit.Test;

/**
 * by MrThanksgiving
 */
public class Code155MinStackTest {

    @Test
    public void testSolution() {
        Code155MinStack solution = new Code155MinStack();
        solution.push(2);
        solution.push(0);
        solution.push(3);
        solution.push(0);

        MyUtils.println(MyUtils.ANSI_RED + solution.getMin() + MyUtils.ANSI_RESET);
        solution.pop();
        MyUtils.println(MyUtils.ANSI_RED + solution.getMin() + MyUtils.ANSI_RESET);
        solution.pop();
        MyUtils.println(MyUtils.ANSI_RED + solution.getMin() + MyUtils.ANSI_RESET);
        solution.pop();
        MyUtils.println(MyUtils.ANSI_RED + solution.getMin() + MyUtils.ANSI_RESET);
    }
}

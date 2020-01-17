package com.coolslow.topics.backtracking;

import com.coolslow.datastruct.utils.MyUtils;
import com.coolslow.leetcode.topics.backtracking.Code22GenerateParentheses;
import org.junit.Test;

import java.util.List;

/**
 * by MrThanksgiving
 */
public class Code22GenerateParenthesesTest {

    @Test
    public void testSolution() {
        Code22GenerateParentheses solution = new Code22GenerateParentheses();
        int input = 3;
        List<String> result = solution.generateParenthesis(input);
        MyUtils.println(MyUtils.ANSI_RED + result + MyUtils.ANSI_RESET);
    }
}

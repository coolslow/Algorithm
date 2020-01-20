package com.coolslow.topics.math;

import com.coolslow.datastruct.utils.MyUtils;
import com.coolslow.leetcode.topics.math.Code171ExcelSheetColumnNumber;
import org.junit.Test;

/**
 * by MrThanksgiving
 */
public class Code171ExcelSheetColumnNumberTest {

    @Test
    public void testSolution() {
        Code171ExcelSheetColumnNumber solution = new Code171ExcelSheetColumnNumber();
        String input = "AB";
        int result = solution.titleToNumber(input);
        MyUtils.println(MyUtils.ANSI_RED + result + MyUtils.ANSI_RESET);
    }
}

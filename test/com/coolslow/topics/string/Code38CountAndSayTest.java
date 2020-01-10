package com.coolslow.topics.string;

import com.coolslow.datastruct.utils.MyUtils;
import com.coolslow.leetcode.topics.string.Code38CountAndSay;
import org.junit.Test;

/**
 * by MrThanksgiving
 */
public class Code38CountAndSayTest {

    @Test
    public void testSolution() {
        Code38CountAndSay solution = new Code38CountAndSay();

        int nums = 10;
        for (int i = 1; i <= nums; i++) {
            String result = solution.countAndSay(i);
            MyUtils.println(MyUtils.ANSI_RED + i + "=" + result + MyUtils.ANSI_RESET);
        }

    }
}
/*
 *
 1.     1
 2.     11
 3.     21
 4.     1211
 5.     111221
 6.     312211
 7.     13112221
 8.     1113213211
 9.     31131211131221
10.     13211311123113112211
 */

package com.coolslow.topics.array;

import com.coolslow.datastruct.utils.MyUtils;
import com.coolslow.leetcode.topics.array.Code345ReverseVowelsOfAString;
import org.junit.Test;

/**
 * by MrThanksgiving
 */
public class Code345ReverseVowelsOfAStringTest {

    @Test
    public void testSolution() {
        Code345ReverseVowelsOfAString solution = new Code345ReverseVowelsOfAString();
//        String s = "hello";
        String s = "leetcode";
        String result = solution.reverseVowels(s);
        MyUtils.println(MyUtils.ANSI_RED + result + MyUtils.ANSI_RESET);
    }
}

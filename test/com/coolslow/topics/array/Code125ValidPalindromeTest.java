package com.coolslow.topics.array;

import com.coolslow.datastruct.utils.MyUtils;
import com.coolslow.leetcode.topics.array.Code125ValidPalindrome;
import org.junit.Test;

/**
 * by MrThanksgiving
 */
public class Code125ValidPalindromeTest {

    @Test
    public void testSolution() {
        Code125ValidPalindrome solution = new Code125ValidPalindrome();
        String[] ss = {
                "A man, a plan, a canal: Panama",
                "race a car",
                ".,",
                "a."
        };
        for (String s : ss) {
            boolean result = solution.isPalindrome(s);
            MyUtils.println(MyUtils.ANSI_RED + result + MyUtils.ANSI_RESET);
        }

    }
}

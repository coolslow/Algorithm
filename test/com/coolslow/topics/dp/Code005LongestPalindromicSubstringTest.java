package com.coolslow.topics.dp;

import com.coolslow.datastruct.utils.MyUtils;
import com.coolslow.leetcode.topics.dp.Code005LongestPalindromicSubstring;
import org.junit.Test;

/**
 * 最长回文子串
 * by MrThanksgiving
 */
public class Code005LongestPalindromicSubstringTest {

    @Test
    public void testSolution() {
        Code005LongestPalindromicSubstring solution = new Code005LongestPalindromicSubstring();
        String result = solution.longestPalindrome("babad");
//        String result = solution.longestPalindrome("cbbd");
        MyUtils.print(MyUtils.ANSI_RED + result + MyUtils.ANSI_RESET);
    }


}

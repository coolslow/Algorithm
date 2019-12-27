package com.coolslow.topics.dp;

import com.coolslow.datastruct.utils.MyUtils;
import com.coolslow.leetcode.topics.dp.Code5LongestPalindromicSubstring;
import org.junit.Test;

/**
 * 最长回文子串
 * by MrThanksgiving
 */
public class Code5LongestPalindromicSubstringTest {

    @Test
    public void testSolution() {
        Code5LongestPalindromicSubstring solution = new Code5LongestPalindromicSubstring();
        String result = solution.longestPalindrome("babad");
//        String result = solution.longestPalindrome("cbbd");
        MyUtils.print(MyUtils.ANSI_RED + result + MyUtils.ANSI_RESET);
    }


}

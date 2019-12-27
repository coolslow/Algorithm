package com.coolslow.topics.dp;

import com.coolslow.datastruct.utils.MyUtils;
import com.coolslow.leetcode.topics.dp.Code0005LongestPalindromicSubstring;
import org.junit.Test;

/**
 * 最长回文子串
 * by MrThanksgiving
 */
public class Code0005LongestPalindromicSubstringTest {

    @Test
    public void testSolution() {
        Code0005LongestPalindromicSubstring solution = new Code0005LongestPalindromicSubstring();
        String result = solution.longestPalindrome("babad");
//        String result = solution.longestPalindrome("cbbd");
        MyUtils.print(MyUtils.ANSI_RED + result + MyUtils.ANSI_RESET);
    }


}

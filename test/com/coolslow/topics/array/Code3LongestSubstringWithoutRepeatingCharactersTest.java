package com.coolslow.topics.array;

import com.coolslow.datastruct.utils.MyUtils;
import com.coolslow.leetcode.topics.array.Code3LongestSubstringWithoutRepeatingCharacters;
import org.junit.Test;

/**
 * by MrThanksgiving
 */
public class Code3LongestSubstringWithoutRepeatingCharactersTest {

    @Test
    public void testSolution() {
        Code3LongestSubstringWithoutRepeatingCharacters solution = new Code3LongestSubstringWithoutRepeatingCharacters();
        String[] input = {
                "abcabcbb", "pwwkew", "bbbbb", "aaapapapapapwedcdp",
                "tmmzuxt"};
        for (String i : input) {
            int result = solution.lengthOfLongestSubstring(i);
            MyUtils.println(MyUtils.ANSI_RED + result + MyUtils.ANSI_RESET);
        }

    }
}

package com.coolslow.topics.string;

import com.coolslow.datastruct.utils.MyUtils;
import com.coolslow.leetcode.topics.string.Code14LongestCommonPrefix;
import org.junit.Test;

/**
 * by MrThanksgiving
 */
public class Code14LongestCommonPrefixTest {

    @Test
    public void testSolution() {
        Code14LongestCommonPrefix solution = new Code14LongestCommonPrefix();
        String[][] strs = {
                {"flower", "flow", "flight"},
                {"dog", "racecar", "car"},
                {"c", "c"},
                {"", ""},
                {"aa", "a"},
                {"a", "aa"}
        };
        for (String[] str : strs) {
            String result = solution.longestCommonPrefix(str);
            MyUtils.println(MyUtils.ANSI_RED + result + MyUtils.ANSI_RESET);
        }

//

    }
}

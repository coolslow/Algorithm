package com.coolslow.topics.string;

import com.coolslow.datastruct.utils.MyUtils;
import com.coolslow.leetcode.topics.string.Code387FirstUniqueCharacterInAString;
import org.junit.Test;

/**
 * by MrThanksgiving
 */
public class Code387FirstUniqueCharacterInAStringTest {

    @Test
    public void testSolution() {
        Code387FirstUniqueCharacterInAString solution = new Code387FirstUniqueCharacterInAString();
        String s = "leetcode";
//        String s = "loveleetcode";
        int result = solution.firstUniChar(s);
        MyUtils.println(MyUtils.ANSI_RED + result + MyUtils.ANSI_RESET);
    }
}

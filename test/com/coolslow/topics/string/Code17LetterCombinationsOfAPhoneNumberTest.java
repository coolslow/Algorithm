package com.coolslow.topics.string;

import com.coolslow.datastruct.utils.MyUtils;
import com.coolslow.leetcode.topics.string.Code17LetterCombinationsOfAPhoneNumber;
import org.junit.Test;

import java.util.List;

/**
 * by MrThanksgiving
 */
public class Code17LetterCombinationsOfAPhoneNumberTest {

    @Test
    public void testSolution() {
        Code17LetterCombinationsOfAPhoneNumber solution = new Code17LetterCombinationsOfAPhoneNumber();
        String input = "23";
        List<String> result = solution.letterCombinations(input);
        MyUtils.printArray(result);
    }
}

package com.coolslow.topics.array;

import com.coolslow.datastruct.utils.MyUtils;
import com.coolslow.leetcode.topics.array.Code49GroupAnagrams;
import org.junit.Test;

import java.util.List;

/**
 * by MrThanksgiving
 */
public class Code49GroupAnagramsTest {

    @Test
    public void testSolution() {
        Code49GroupAnagrams solution = new Code49GroupAnagrams();
//        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
//        String[] input = {"", "b"};
        String[] input = {"tea","and","ace","ad","eat","dans"};
        List<List<String>> result = solution.groupAnagrams(input);
        for (List<String> l : result) {
            MyUtils.printArray(l);
        }
    }
}

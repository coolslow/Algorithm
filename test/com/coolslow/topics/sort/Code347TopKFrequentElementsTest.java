package com.coolslow.topics.sort;

import com.coolslow.datastruct.utils.MyUtils;
import com.coolslow.leetcode.topics.sort.Code347TopKFrequentElements;
import org.junit.Test;

import java.util.List;

/**
 * by MrThanksgiving
 */
public class Code347TopKFrequentElementsTest {

    @Test
    public void testSolution() {
        Code347TopKFrequentElements solution = new Code347TopKFrequentElements();
        int[] input = {1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3};
        int k = 2;
        List<Integer> result = solution.topKFrequent(input, k);
        MyUtils.printArray(result);
    }
}

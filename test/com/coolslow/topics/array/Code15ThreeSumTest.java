package com.coolslow.topics.array;

import com.coolslow.datastruct.utils.MyUtils;
import com.coolslow.leetcode.topics.array.Code15ThreeSum;
import org.junit.Test;

import java.util.List;

/**
 * by MrThanksgiving
 */
public class Code15ThreeSumTest {

    @Test
    public void testSolution() {
        Code15ThreeSum solution = new Code15ThreeSum();
        int[] input = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = solution.threeSum(input);
        for (List<Integer> list : result) {
            MyUtils.printArray(list);
        }
    }

}

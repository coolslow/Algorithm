package com.coolslow.topics.array;

import com.coolslow.datastruct.utils.MyUtils;
import com.coolslow.leetcode.topics.array.Code118PascalsTriangle;
import org.junit.Test;

import java.util.List;

/**
 * by MrThanksgiving
 */
public class Code118PascalsTriangleTest {

    @Test
    public void testSolution() {
        Code118PascalsTriangle solution = new Code118PascalsTriangle();
        int n = 0;
        List<List<Integer>> result = solution.generate(n);
        for (List<Integer> l : result) {
            MyUtils.printArray(l);
        }
    }
}

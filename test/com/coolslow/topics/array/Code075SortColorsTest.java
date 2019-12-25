package com.coolslow.topics.array;

import com.coolslow.datastruct.utils.MyUtils;
import com.coolslow.leetcode.topics.array.Code075SortColors;
import org.junit.Test;

/**
 * by MrThanksgiving
 */
public class Code075SortColorsTest {

    @Test
    public void testSolution() {
        Code075SortColors solution = new Code075SortColors();
        int[][] nums = {
//                {2, 0, 2, 1, 1, 0},
//                {2},
//                {0, 2},
//                {2, 0},
//                {2, 1, 0},
//                {1, 2, 0},
                {0,1,0}
        };
        for (int[] num : nums) {
            solution.sortColors(num);
            MyUtils.printArray(num);
        }

    }
}

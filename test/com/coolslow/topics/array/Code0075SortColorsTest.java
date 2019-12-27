package com.coolslow.topics.array;

import com.coolslow.datastruct.utils.MyUtils;
import com.coolslow.leetcode.topics.array.Code0075SortColors;
import org.junit.Test;

/**
 * by MrThanksgiving
 */
public class Code0075SortColorsTest {

    @Test
    public void testSolution() {
        Code0075SortColors solution = new Code0075SortColors();
        int[][] nums = {
//                {2, 0, 2, 1, 1, 0},
//                {2},
//                {0, 2},
//                {2, 0},
//                {2, 1, 0},
//                {1, 2, 0},
                {0, 1, 0}
        };
        for (int[] num : nums) {
            solution.sortColors(num);
            MyUtils.printArray(num);
        }

    }

}
